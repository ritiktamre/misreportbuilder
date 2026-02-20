package com.example.misreport.util;

import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class CsvExportUtil {

    public static ByteArrayInputStream export(List<Map<String, Object>> data) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVWriter writer = new CSVWriter(new OutputStreamWriter(out));

        if (!data.isEmpty()) {
            writer.writeNext(data.get(0).keySet().toArray(new String[0]));

            for (Map<String, Object> row : data) {
                writer.writeNext(row.values().stream()
                        .map(String::valueOf)
                        .toArray(String[]::new));
            }
        }

        writer.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}