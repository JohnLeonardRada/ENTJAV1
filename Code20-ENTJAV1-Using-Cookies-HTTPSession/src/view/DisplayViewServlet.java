           boolean looseMatch) {
        super(patternMatcher);
        for (String name : configs.keySet()) {
            addPattern(name, configs.get(name), looseMatch);
        }
    }

    /**
     * <p> Clones the ActionConfig and its children, replacing various
     * properties with the values of the wildcard-matched strings. </p>
     *
     * @param path The requested path
     * @param orig The original ActionConfig
     * @param vars A Map of wildcard-matched strings
     * @return A cloned ActionConfig with appropriate properties replaced with
     *         wildcard-matched values
     */
    @Override public ActionConfig convert(String path, ActionConfig orig,
        Map<String, String> vars) {

        String methodName = convertParam(orig.getMethodName(), vars);
        if (!orig.isAllowedMethod(methodName)) {
            return null;
        }

        String className = convertParam(orig.getClassName(), vars);
        String pkgName = convertParam(orig.getPackageName(), vars);

        Map<String,String> params = replaceParameters(orig.getParams(), vars);

        Map<String,ResultConfig> results = new LinkedHashMap<String,ResultConfig>();
        for (String name : orig.getResults().keySet()) {
            ResultConfig result = orig.getResults().get(name);
            name = convertParam(name, vars);
            ResultConfig r = new ResultConfig.Builder(name, convertParam(result.getClassName(), vars))
                    .addParams(replaceParameters(result.getParams(), vars))
                    .build();
            results.put(name, r);
        }

        List<ExceptionMappingConfig> exs = new ArrayList<ExceptionMappingConfig>();
        for (ExceptionMappingConfig ex : orig.getExceptionMappings()) {
            String name = convertParam(ex.getName(), vars);
            String exClassName = convertParam(ex.getExceptionClassName(), vars);
            String exResult = convertParam(ex.getResult(), vars);
            Map<String,String> exParams = replaceParameters(ex.getParams(), vars);
            ExceptionMappingConfig e = new ExceptionMappingConfig.Builder(name, exClassName, exResult).addParams(exParams).build();
            exs.add(e);
        }

        return new ActionConfig.Builder(pkgName, orig.getName(), className)
                .methodName(methodName)
                .addParams(params)
                .addResultConfigs(results)
                .addInterceptors(orig.getInterceptors())
                .addExceptionMappings(exs)
                .location(orig.getLocation())
                .build();
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              