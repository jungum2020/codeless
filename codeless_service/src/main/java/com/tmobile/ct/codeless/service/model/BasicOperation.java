/*******************************************************************************
 * * Copyright 2018 T Mobile, Inc. or its affiliates. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  * use this file except in compliance with the License.  You may obtain a copy
 *  * of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  * License for the specific language governing permissions and limitations under
 *  * the License.
 ******************************************************************************/
package com.tmobile.ct.codeless.service.model;

import java.util.Optional;

import com.tmobile.ct.codeless.service.HttpRequest;
import com.tmobile.ct.codeless.service.httpclient.HttpMethod;

/**
 * The Class BasicOperation.
 *
 * @author Rob Graff
 */
public class BasicOperation implements Operation{

	/** The name. */
	private String name;
	
	/** The method. */
	private HttpMethod method;
	
	/** The path. */
	private String path;
	
	/** The request. */
	private HttpRequest request;
	
	/** The key. */
	private OperationKey key;
	
	/** The service. */
	private Service service;
	
	/**
	 * Instantiates a new basic operation.
	 *
	 * @param method the method
	 * @param servicePath the service path
	 * @param operationPath the operation path
	 * @param request the request
	 */
	public BasicOperation(HttpMethod method, String servicePath, String operationPath, HttpRequest request){
		this.name = request.getRequestName();
		this.method = method;
		this.path = new StringBuilder().append(Optional.ofNullable(servicePath).orElse("")).append(Optional.ofNullable(operationPath).orElse("")).toString();
		this.request = request;
		this.key = new OperationKey(method,servicePath,operationPath);
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#getMethod()
	 */
	@Override
	public HttpMethod getMethod() {
		return method;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#setMethod(com.tmobile.ct.codeless.service.httpclient.HttpMethod)
	 */
	@Override
	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#getPath()
	 */
	@Override
	public String getPath() {
		return path;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#setPath(java.lang.String)
	 */
	@Override
	public void setPath(String path) {
		this.path = path;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#getRequest()
	 */
	@Override
	public HttpRequest getRequest() {
		return request;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#setRequest(com.tmobile.ct.codeless.service.HttpRequest)
	 */
	@Override
	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#getKey()
	 */
	@Override
	public OperationKey getKey() {
		return key;
	}
	
	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#getService()
	 */
	@Override
	public Service getService() {
		return service;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.model.Operation#setService(com.tmobile.ct.codeless.service.model.Service)
	 */
	@Override
	public void setService(Service service) {
		this.service = service;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BasicOperation [name=").append(name).append(", method=").append(method).append(", path=")
				.append(path).append(", request=").append(request).append(", key=").append(key).append(", service=")
				.append(service).append("]");
		return builder.toString();
	}
}
