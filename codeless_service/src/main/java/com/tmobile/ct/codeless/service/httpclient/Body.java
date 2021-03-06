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
package com.tmobile.ct.codeless.service.httpclient;

import com.tmobile.ct.codeless.core.TestData;

/**
 * The Class Body.
 *
 * @author Rob Graff
 * @param <T> the generic type
 */
public class Body<T> {

	/** The body. */
	private T body;
	
	/** The type. */
	private Class<T> type;
	
	/** The template. */
	private String template;
	
	/** The test data. */
	private TestData testData;
	
	/**
	 * Instantiates a new body.
	 *
	 * @param body the body
	 * @param type the type
	 */
	public Body(T body, Class<T> type){
		this.body = body;
		this.type = type;
	}
	
	/**
	 * Instantiates a new body.
	 */
	public Body(){}
	
	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public T getBody(){
		return body;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Class<T> getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type
	 * @return the body
	 */
	public Body<T> setType(Class<T> type) {
		this.type = type;
		return this;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the body
	 * @return the body
	 */
	public Body<T> setBody(T body) {
		this.body = body;
		return this;
	}

	/**
	 * Gets the template.
	 *
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * Sets the template.
	 *
	 * @param template the template
	 * @return the body
	 */
	public Body<T> setTemplate(String template) {
		this.template = template;
		return this;
	}

	/**
	 * Gets the test data.
	 *
	 * @return the test data
	 */
	public TestData getTestData() {
		return testData;
	}

	/**
	 * Sets the test data.
	 *
	 * @param testData the test data
	 * @return the body
	 */
	public Body<T> setTestData(TestData testData) {
		this.testData = testData;
		return this;
	}
	
	/**
	 * As string.
	 *
	 * @return the string
	 */
	public String asString(){
		return this.body.toString();
	}
}
