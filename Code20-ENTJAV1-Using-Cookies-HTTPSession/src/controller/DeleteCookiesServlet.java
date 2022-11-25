/*
 * Copyright 2002-2006,2009 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensymphony.xwork2.config.providers;

import com.opensymphony.xwork2.ObjectFactory;
import com.opensymphony.xwork2.config.ConfigurationException;
import com.opensymphony.xwork2.config.entities.InterceptorConfig;
import com.opensymphony.xwork2.config.entities.InterceptorLocator;
import com.opensymphony.xwork2.config.entities.InterceptorMapping;
import com.opensymphony.xwork2.config.entities.InterceptorStackConfig;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.location.Location;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Builds a list of interceptors referenced by the refName in the supplied PackageConfig.
 *
 * @author Mike
 * @author Rainer Hermanns
 * @author tmjee
 * @version $Date: 2013-01-15 21:58:08 +0100 (Tue, 15 Jan 2013) $ $Id: InterceptorBuilder.java 1433644 2013-01-15 20:58:08Z lukaszlenart $
 */
public class InterceptorBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(InterceptorBuilder.class);


    /**
     * Builds a list of interceptors referenced by the refName in the supplied PackageCo