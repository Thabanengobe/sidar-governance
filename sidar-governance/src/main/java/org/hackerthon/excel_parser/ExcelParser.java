package org.hackerthon.excel_parser;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelParser {

    public static void main(String[] args) {
        String excelFilePath = "sidar-governance/src/main/java/org/hackerthon/excel_parser/questions.xlsx";

        try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
             Workbook workbook = WorkbookFactory.create(inputStream)) {

            List<List<String>> tablesData = new ArrayList<>();

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rowIterator = sheet.iterator();
                List<String> tableData = new ArrayList<>();

                // Skip the header row if needed
                if (rowIterator.hasNext()) {
                    rowIterator.next();
                }

                int linesInGroup = 14;
                int linesCount = 0;

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    // Assuming the question is in column B
                    Cell questionCell = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    // Extract question
                    String question = questionCell.getStringCellValue().trim();

                    // Skip empty strings and specific lines
                    if (!question.isEmpty() && !shouldSkipLine(question)) {
                        tableData.add("Question: " + question);
                        linesCount++;

                        // If the group is complete, add to the overall list and reset the count
                        if (linesCount == linesInGroup) {
                            tablesData.add(new ArrayList<>(tableData));
                            tableData.clear();
                            linesCount = 0;
                        }
                    }
                }

                // If there are remaining lines, add them to the overall list
                if (!tableData.isEmpty()) {
                    tablesData.add(new ArrayList<>(tableData));
                }
            }

            System.out.println(tablesData.get(0).size());
            System.out.println(tablesData.get(1).size());
            System.out.println(tablesData.get(2).size());
            System.out.println(tablesData.get(3).size());

            // Print the extracted questions
            // for (int i = 0; i < tablesData.size(); i++) {
            //     System.out.println("Table " + (i + 1) + " - Questions:");
            //     for (String question : tablesData.get(i)) {
            //         System.out.println("  " + question);
            //     }
            // }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Check if a line should be skipped
    private static boolean shouldSkipLine(String line) {
        // Add conditions to skip specific lines
        return line.equals("") ||
               line.equals("Sirdar Governance Implementation Diagnostic") ||
               line.equals("Enterprise Purpose") ||
               line.startsWith("Where the board has committee structures in place (complete as appopriate)") ||
               line.equals("Accountability for Performance") ||
               line.equals("Sustainability") ||
               line.equals("Conformance");
    }
}
