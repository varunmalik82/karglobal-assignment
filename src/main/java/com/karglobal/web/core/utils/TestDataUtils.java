package com.karglobal.web.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class TestDataUtils {
    private final static String TEST_DATA_JSON_FILE_LOCATION = System.getProperty("user.dir") + "/src/test/resources" +
            "/TestData.json";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public synchronized static Object[][] getTestData() {
        try {
            InputStream stream = new FileInputStream(TEST_DATA_JSON_FILE_LOCATION);
            Map<Object, Map<Object, Object>> jsonDataMap = MAPPER.readValue(stream, Map.class);
            System.out.println(jsonDataMap.size());
            System.out.println(jsonDataMap);
            TestDataRow[][] testDataRowsMap = new TestDataRow[jsonDataMap.size()][1];
            int count = 0;
            for (Object key : jsonDataMap.keySet()) {
                TestDataRow testDataRow = putDataInTestDataRowObject(jsonDataMap.get(key));
                testDataRowsMap[count][0] = testDataRow;
                count++;
            }
            return testDataRowsMap;
        } catch (Exception e) {
            System.err.println("Exception occurred while parsing test data from TestData.json" + e.getMessage());
            e.printStackTrace();
        }
        return null;

    }

    private static TestDataRow putDataInTestDataRowObject(Map<Object, Object> map) {
        TestDataRow testDataRow = new TestDataRow();
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            testDataRow.addDataToRow((String) key, (String) value);
        }
        return testDataRow;
    }

}
