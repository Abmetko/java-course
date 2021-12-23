package com.io.open_csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class CsvReader {

    private static CSVReader csvReader;
    private static int numberOfAllLines;

    private CsvReader() {
    }

    @SneakyThrows
    public static CSVReader getCsvReader() {
        if (csvReader == null) {
            csvReader = new CSVReaderBuilder(new FileReader("src/main/java/com/io/file/file_test2.CSV"))
                    .withSkipLines(1)
                    .build();

            numberOfAllLines = csvReader.peek().length;
        }
        return csvReader;
    }

    @SneakyThrows
    public static synchronized List<String[]> readLinesFromCsvFile() {
        List<String[]> lines = new ArrayList<>();
        long linesRead;
        String[] line;

        while ((line = getCsvReader().readNext()) != null) {
            lines.add(line);
        }
        csvReader.close();
        return lines;
    }

    public static void main(String[] args) {
        for (String[] line : readLinesFromCsvFile()) {
            System.out.println("This is " + line[0] + ", his age is - " + line[2]);
        }
    }
}