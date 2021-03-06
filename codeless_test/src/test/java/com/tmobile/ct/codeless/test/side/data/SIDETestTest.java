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
package com.tmobile.ct.codeless.test.side.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SIDETestTest {

	private static SIDETest sideTest = new SIDETest();

	@Test
	public void testSetAndGetId() {
		String expected = "id";
		sideTest.setId(expected);
		Assert.assertEquals(expected, sideTest.getId());
	}

	@Test
	public void testSetAndGetName() {
		String expected = "name";
		sideTest.setId(expected);
		Assert.assertEquals(expected, sideTest.getId());
	}

	@Test
	public void testSetAndGetCommands() {
		List<SIDEStep> expected = SIDEStepTest.createListOfSideSteps();
		sideTest.setCommands(expected);
		Assert.assertEquals(expected.size(), sideTest.getCommands().size());
	}
	
	public static SIDETest createSideTest() {
		
		SIDETest sideTest = new SIDETest();
		sideTest.setId("id");
		sideTest.setName("test");
		sideTest.setCommands(SIDEStepTest.createListOfSideSteps());
		sideTest.setAdditionalProperties(new HashMap<String, Object>());
		return sideTest;
	}
	
	public static List<SIDETest> createListOfSideTests() {

		return Arrays.asList(createSideTest(), createSideTest());
	}
}
