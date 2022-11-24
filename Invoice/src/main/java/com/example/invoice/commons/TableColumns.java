

package com.example.invoice.commons;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class TableColumns {

    private final static List<String> values = new ArrayList<>();

    public static List<String> getValues() {
        values.add("ref");
        values.add("amount");
        values.add("names");
        values.add("dates");
        values.add("types");

        return values;
    }



    private final static LinkedHashMap<String, String> columns1 = new LinkedHashMap<>();

    public TableColumns() {
    }

    public static LinkedHashMap<String, String> getColumns1() {
        columns1.put("type", "i2.type");
        columns1.put("ref", "r.ext_ref");
        columns1.put("amount", "i.amount");
        columns1.put("date", "i.issue_date");
        return columns1;
    }




}
