package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public String path;

    // Constructor to initialize file path
    public ExcelUtility(String path) {
        this.path = path;
    }

    // Get the number of rows in a sheet
    public int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }

    // Get the number of columns in a specific row
    public int getCellCount(String sheetName, int rowNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;
    }

    // Read data from a specific cell
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        String data;
        try {
            DataFormatter formatter = new DataFormatter(); // Format data as text
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = ""; // Return empty string if cell is null
        }

        workbook.close();
        fi.close();
        return data;
    }

    // Write or update data in a specific cell
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        File file = new File(path);

        // If file does not exist, create a new workbook and file
        if (!file.exists()) {
            workbook = new XSSFWorkbook();
            fo = new FileOutputStream(path);
            workbook.write(fo);
            workbook.close();
        }

        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        // If sheet does not exist, create a new sheet
        if (workbook.getSheetIndex(sheetName) == -1) {
            workbook.createSheet(sheetName);
        }

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);

        // If row does not exist, create a new row
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        cell = row.getCell(colNum);

        // If cell does not exist, create a new cell
        if (cell == null) {
            cell = row.createCell(colNum);
        }

        cell.setCellValue(data);

        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }

    // Check if a sheet exists in the workbook
    public boolean isSheetExist(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        boolean sheetExists = workbook.getSheetIndex(sheetName) != -1;
        workbook.close();
        fi.close();
        return sheetExists;
    }

    // Create a new sheet
    public void createSheet(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        // Create a new sheet if it does not already exist
        if (workbook.getSheetIndex(sheetName) == -1) {
            workbook.createSheet(sheetName);
        }

        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
}