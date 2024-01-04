package com.trung.qotd.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Stream;
import java.util.stream.Collectors;

public class CSVWriter {
    private static final String COMMA = ",";
    private static final String SINGLE_QUOTE = "'";
    private static final String DOUBLE_QUOTES = "\"";
    private static final String EMBEDDED_DOUBLE_QUOTES = "\"\"";
    private static final String NEW_LINE_UNIX = "\n";
    private static final String NEW_LINE_WINDOWS = "\r\n";
    
    private static final String DEFAULT_SEPARATOR = COMMA;
    
    public String convertToCSVFormat(String[] line) {
    	return this.convertToCSVFormat(line, DEFAULT_SEPARATOR);
    }
    
    public String convertToCSVFormat(String[] line, String separator) {
    	return this.convertToCSVFormat(line, separator, true);
    }

    public String convertToCSVFormat(String[] line,
    							String separator, final boolean isQuote) {
    	return Stream.of(line)
    			.map(fieldValue -> convertToCSVFieldFormat(fieldValue, isQuote))
    			.collect(Collectors.joining(separator));
    }
    
    public void write(List<String[]> list, File file) throws IOException {

        List<String> collect = list.stream()
        							.map(this::convertToCSVFormat)
        							.collect(Collectors.toList());

        // CSV is a normal text file, need a writer
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(file)) ) {
            for (String line : collect) {
                bw.write(line);
                bw.newLine();
            }
        }

    }
    

    private String convertToCSVFieldFormat(String fieldValue, final boolean isQuote) {
        String result = fieldValue;

        if (result.contains(COMMA) || result.contains(DOUBLE_QUOTES)
                || result.contains(NEW_LINE_UNIX) || result.contains(NEW_LINE_WINDOWS) ) {

            // if field contains double quotes, replace it with single quote \"\"
            result = result.replace(DOUBLE_QUOTES, SINGLE_QUOTE);

            // must wrap by or enclosed with double quotes
            result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;

        } else {
            // should all fields enclosed in double quotes
            if (isQuote) {
                result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;
            }
        }

        return result;   	
    }
}