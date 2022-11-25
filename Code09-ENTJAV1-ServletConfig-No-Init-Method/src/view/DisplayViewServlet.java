/*
 * $Id: DefaultActionMapperTest.java 780092 2009-05-29 20:15:14Z wesw $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.struts2.dispatcher.mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.apache.struts2.dispatcher.StrutsResultSupport;
import org.apache.struts2.views.jsp.StrutsMockHttpServletRequest;
import org.apache.struts2.views.jsp.StrutsMockHttpServletResponse;

import com.mockobjects.dynamic.Mock;
import com.mockobjects.servlet.MockHttpServletRequest;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.entities.PackageConfig;
import com.opensymphony.xwork2.config.impl.DefaultConfiguration;

/**
 * DefaultActionMapper test case.
 *
 */
public class DefaultActionMapperTest extends StrutsTestCase {

    private MockHttpServletRequ