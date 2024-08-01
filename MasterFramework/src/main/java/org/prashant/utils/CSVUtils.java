package org.prashant.utils;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static List<String[]> readCsv() {

        List<String[]> data = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader("filePath"))) {
            data = csvReader.readAll();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return data;
    }
}
