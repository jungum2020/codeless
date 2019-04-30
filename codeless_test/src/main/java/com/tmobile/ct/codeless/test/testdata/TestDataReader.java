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
package com.tmobile.ct.codeless.test.testdata;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tmobile.ct.codeless.core.Suite;
import com.tmobile.ct.codeless.core.TestData;
import com.tmobile.ct.codeless.core.TestDataSource;
import com.tmobile.ct.codeless.core.config.Config;
import com.tmobile.ct.codeless.core.datastructure.SourcedValue;
import com.tmobile.ct.codeless.data.BasicTestData;
import com.tmobile.ct.codeless.data.SourcedDataItem;
import com.tmobile.ct.codeless.test.csv.CsvTestData;
import com.tmobile.ct.codeless.test.excel.ExcelTestData;
import com.tmobile.ct.codeless.testdata.StaticTestDataSource;

/**
 * The Class TestDataReader.
 *
 * @author Sai Chandra Korpu
 */
public class TestDataReader {

	private static Logger log = LoggerFactory.getLogger(TestDataReader.class);

	public static TestData getTestData(Suite suite, TestData testData) {

		if (testData == null) testData = new BasicTestData();

		if (suite.getConfig() != null) {

			String testDataFileName = suite.getConfig().get(Config.TESTDATA_FILENAME).fullfill();
			String path = ".." + File.separator + "testdata" + File.separator + testDataFileName;
			if (path.contains(Config.EXCEL_EXTENSION)) {
				new ExcelTestData(suite, testData).parseExcelTestDataFile(path);
				
			} else if (path.contains(Config.CSV_EXTENSION)) {

				try {
					new CsvTestData(suite, testData).parseCsvTestDataSheet(path);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		return testData;
	}
	
	public static void createStaticTestData (String key, String key_value, TestData testData, String source ) {
		
		String value = "";
		SourcedDataItem<String, TestDataSource> sourcedDataItem = testData.getSourcedValue(key);
     
		// create static test data
		if (sourcedDataItem == null) {
			
			StaticTestDataSource staticSource = null;
			
			// check in system property
			value = System.getProperty(key);
			
			// check in environment property
			if (StringUtils.isBlank(value)) {
				value = System.getenv(key);
			}
			
			staticSource = !StringUtils.isEmpty(value) ? new StaticTestDataSource(key, value)
					: new StaticTestDataSource(key, key_value);

			SourcedValue<TestDataSource> sourcedValue = new SourcedValue<>();
			sourcedValue.setSource(source);
			sourcedValue.setSourceClass(TestDataReader.class);
			sourcedValue.setValue(staticSource);
			SourcedDataItem<String, TestDataSource> item = new SourcedDataItem<>(key, sourcedValue);
			
			testData.put(key, item);
		} else {

			// replace master test data with environment test data
			TestDataSource testDataSource = sourcedDataItem.getValue().getValue();

			if (testDataSource != null && testDataSource instanceof StaticTestDataSource) {
				testDataSource.setValue(key_value);
			}
		}
		
	}

}