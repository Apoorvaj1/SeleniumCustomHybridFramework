package org.selenium.aj.DDT;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ExcelReader {
    public ExcelReader(String testDataFile) {
    }

    public String[][] getDataFromSheet(String workbooklocation, String workSheetName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir")+"/"+workbooklocation);
        XSSFSheet workSheet = workbook.getSheet(workSheetName);
        int noOfRows = workSheet.getLastRowNum()+1;
        int noOfColumns = workSheet.getRow(0).getLastCellNum();
        String[][] dataTable = new String[noOfRows][noOfColumns];
        for(int i= workSheet.getFirstRowNum();i<workSheet.getLastRowNum()+1;i++){
            Row row = workSheet.getRow(i);
            for(int j=row.getFirstCellNum();j<row.getLastCellNum();j++){
                Cell cell = row.getCell(j);
                dataTable[i][j]=cell.getStringCellValue();
            }
        }
        workbook.close();
        return dataTable;
    }
}
