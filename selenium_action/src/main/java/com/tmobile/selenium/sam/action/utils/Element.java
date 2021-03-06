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
package com.tmobile.selenium.sam.action.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tmobile.selenium.sam.action.types.WaitType;

/**
 * The Class Element.
 *
 * @author Rob Graff (RGraff1)
 */
public class Element {

	/** The wait time. */
	private int waitTime;
	
	/** The wait type. */
	private WaitType waitType;
	
	/** The element. */
	private WebElement element;

	/**
	 * Instantiates a new element.
	 *
	 * @param element the element
	 * @param waitType the wait type
	 * @param waitTime the wait time
	 */
	public Element( WebElement element, WaitType waitType, int waitTime){
		this.element = element;
		this.waitType = waitType;
		this.waitTime = waitTime;
	}

	/**
	 * Gets the.
	 *
	 * @return the web element
	 */
	public WebElement get() {
		return element;
	}
	

	
	/**
	 * Locator.
	 *
	 * @return the string
	 */
	public String locator(){
		try{
			String output = element.toString();
			int cut = 0;
			if(output.lastIndexOf(">") > 0){
				cut = output.lastIndexOf(">");
				return output.substring(cut+2, output.length()-1);
			}else if(output.lastIndexOf("By.") > 0){
				cut = output.lastIndexOf("By.");
				return output.substring(cut+3, output.length()-1);
			}else{
				return element.toString();
			}
		}catch(Exception e){
			return element.toString();
		}
	}
	
	/**
	 * Gets the wait type.
	 *
	 * @return the wait type
	 */
	public WaitType getWaitType(){
		return waitType;
	}

	/**
	 * Gets the wait time.
	 *
	 * @return the wait time
	 */
	public int getWaitTime(){
		return waitTime;
	}

}
