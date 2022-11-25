    result.addAll(stackConfig.getInterceptors());
                }

            } else {
                LOG.error("Got unexpected type for interceptor " + refName + ". Got " + referencedConfig);
            }
        }

        return result;
    }

    /**
     * Builds a list of interceptors referenced by the refName in the supplied PackageConfig overriding the properties
     * of the referenced interceptor with refParams.
     *
     * @param interceptorLocator
     * @param stackConfig
     * @param refParams          The overridden interceptor properies
     * @return list of interceptors referenced by the refName in the supplied PackageConfig overridden with refParams.
     */
    private static List<InterceptorMapping> constructParameterizedInterceptorReferences(
            InterceptorLocator interceptorLocator, InterceptorStackConfig stackConfig, Map<String,String> refParams,
            ObjectFactory objectFactory) {
        List<InterceptorMapping> result;
        Map<String, Map<String, String>> params = new LinkedHashMap<String, Map<String, String>>();

        /*
         * We strip
         *
         * <interceptor-ref name="someStack">
         *    <param name="interceptor1.param1">someValue</param>
         *    <param name="interceptor1.param2">anotherValue</param>
         * </interceptor-ref>
         *
         * down to map
         *  interceptor1 -> [param1 -> someValue, param2 -> anotherValue]
         *
         * or
         * <interceptor-ref name="someStack">
         *    <param name="interceptorStack1.interceptor1.param1">someValue</param>
         *    <param name="interceptorStack1.interceptor1.param2">anotherValue</param>
         * </interceptor-ref>
         *
         * down to map
         *  interceptorStack1 -> [interceptor1.param1 -> someValue, interceptor1.param2 -> anotherValue]
         *
         */
        for (String key : refParams.keySet()) {
            String value = refParams.get(key);

            try {
                String name = key.substring(0, key.indexOf('.'));
                key = key.substring(key.indexOf('.') + 1);

                Map<String, String> map;
                if (params.containsKey(name)) {
                    map = params.get(name);
                } else {
                    map = new LinkedHashMap<String, String>();
                }

                map.put(key, value);
                params.put(name, map);

            } catch (Exception e) {
                if (LOG.isWarnEnabled()) {
                    LOG.warn("No interceptor found for name = #0", key);
                }
            }
        }

        result = new ArrayList<InterceptorMapping>(stackConfig.getInterceptors());

        for (String key : params.keySet()) {

            Map<String, String> map = params.get(key);


            Object interceptorCfgObj = interceptorLocator.getInterceptorConfig(key);

            /*
             * Now we attempt to separate out param that refers to Interceptor
             * and Interceptor stack, eg.
             *
             * <interceptor-ref name="someStack">
             *    <param name="interceptor1.param1">someValue</param>
             *    ...
             * </interceptor-ref>
             *
             *  vs
             *
             *  <interceptor-ref name="someStack">
             *    <param name="interceptorStack1.interceptor1.param1">someValue</param>
             *    ...
             *  </interceptor-ref>
             */
            if (interceptorCfgObj instanceof InterceptorConfig) {  //  interceptor-ref param refer to an interce