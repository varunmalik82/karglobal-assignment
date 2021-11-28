package com.karglobal.web.core.utils;

import java.util.HashMap;
import java.util.Map;


public class TestDataRow {
    private Map<String, String> rowData = new HashMap<>();

    public String addDataToRow(String key, String value) {
        return rowData.put(key, value);
    }

    public String getValue(String key) {
        return rowData.get(key);
    }
}
