/*
 * $Id: ActionConfigMatcher.java 1228497 2012-01-06 23:19:32Z jafl $
 *
 * Copyright 2003,2004 The Apache Software Foundation.
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
package com.opensymphony.xwork2.config.impl;

import com.opensymphony.xwork2.config.entities.ActionConfig;
import com.opensymphony.xwork2.config.entities.ExceptionMappingConfig;
import com.opensymphony.xwork2.config.entities.ResultConfig;
import com.opensymphony.xwork2.util.PatternMatcher;
import com.opensymphony.xwork2.util.WildcardHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> Matches paths against pre-compiled wildcard expressions pulled from
 * action configs. It uses the wildcard matcher from the Apache Cocoon
 * project. Patterns will be matched in the order they exist in the 
 * config file. The first match wins, so more specific patterns should be
 * defined before less specific patterns.
 */
public class ActionConfigMatcher extends AbstractMatcher<ActionConfig> implements Serializable {
   
    /**
     * <p> Finds and precompiles the wildcard patterns from the ActionConfig
     * "path" a