package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class Dataproviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/testData/ebaylogindata.xlsx";
        ExcelUtility xutility = new ExcelUtility(path);

        // Get the total number of rows and columns in the sheet
        int totalRows = xutility.getRowCount("Sheet1");
        int totalCols = xutility.getCellCount("Sheet1", 1); // Ensure only 3 columns (email, password, exp)

        // Debugging: Print row and column count
        System.out.println("Total Rows: " + totalRows);
        System.out.println("Total Columns: " + totalCols);

        // Validate totalCols to avoid mismatch
        if (totalCols != 3) {
            throw new RuntimeException("Expected exactly 3 columns (email, password, exp) in the Excel sheet.");
        }

        // Initialize the 2D array to hold the login data
        String[][] loginData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) { // Skip header row
            for (int j = 0; j < totalCols; j++) {
                String cellData = xutility.getCellData("Sheet1", i, j);

                // Debugging: Print each cell data
                System.out.println("Row " + i + ", Col " + j + ": " + cellData);

                if (cellData == null) {
                    cellData = ""; // Handle null values
                }
                loginData[i - 1][j] = cellData;
            }
        }

        return loginData;
    }
}