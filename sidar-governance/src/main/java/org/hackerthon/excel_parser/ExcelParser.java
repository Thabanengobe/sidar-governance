package org.hackerthon.excel_parser;

import org.apache.poi.ss.usermodel.*;
import org.hackerthon.questionDO.ConformanceDO;
import org.hackerthon.questionDO.PerformanceDO;
import org.hackerthon.questionDO.PurposeDO;
import org.hackerthon.questionDO.SustainabilityDO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelParser {

    private List<List<String>> tablesData;

    public ExcelParser()
    {
        readFile();
    }

    public void readFile()
    {
        String excelFilePath = "sidar-governance/src/main/java/org/hackerthon/excel_parser/questions.xlsx";

        try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
             Workbook workbook = WorkbookFactory.create(inputStream)) {

            this.tablesData = new ArrayList<>();

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
                        tableData.add(question);
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PerformanceDO getPerformanceQO()
    {
        return new PerformanceDO(this.tablesData.get(1));
    }

    public PurposeDO getPurposeQO()
    {
        return new PurposeDO(this.tablesData.get(0));
    }

    public ConformanceDO getConformanceQO()
    {
        return new ConformanceDO(this.tablesData.get(3));
    }

    public SustainabilityDO getSustainabilityQO()
    {
        return new SustainabilityDO(this.tablesData.get(2));
    }

    // Check if a line should be skipped
    private static boolean shouldSkipLine(String line) {
        // Add conditions to skip specific lines
        return line.isEmpty() ||
               line.equals("Sirdar Governance Implementation Diagnostic") ||
               line.equals("Enterprise Purpose") ||
               line.startsWith("Where the board has committee structures in place (complete as appopriate)") ||
               line.equals("Accountability for Performance") ||
               line.equals("Sustainability") ||
               line.equals("Conformance");
    }
}
