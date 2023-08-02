package Test_Data;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excel_Reader {
    static FileInputStream fis=null;
    public FileInputStream getFileInputStream(String path)
    {
        String filePath=System.getProperty("user.dir")+ path;
        File srcFile=new File(filePath);
        try {
            fis=new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test data file not found");
            System.exit(0);
        }
        return fis;
    }
    public Object[][] getDataFromExcelFile(String excelFilePath,int SheetNum) throws IOException {

        fis = getFileInputStream(excelFilePath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(SheetNum);
        int totalNumOfRows = sheet.getLastRowNum();
        int totalNumOfColumns = 0;
        XSSFRow firstRow =sheet.getRow(0);
        if (firstRow != null) {
            totalNumOfColumns = firstRow.getLastCellNum();
        }
        List<String[]> excelDataList = new ArrayList<>();
        // Iterate over the rows in the sheet, starting from the second row
        for (int i = 1; i <= totalNumOfRows; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row == null) {
                // If the row is null, skip it and continue to the next row
                continue;
            }

            String[] rowData = new String[totalNumOfColumns];
            boolean isRowEmpty = true;
            for (int j = 0; j < totalNumOfColumns; j++) {
                if (row.getCell(j) == null) {
                    // If the cell is null, set the corresponding element in the array to an empty string
                    rowData[j] = "";
                } else {
                    rowData[j] = row.getCell(j).toString();
                    isRowEmpty = false;
                }
            }
            if (!isRowEmpty) {
                // Add the row data to the list if it's not empty
                excelDataList.add(rowData);
            }
        }

        wb.close();
        return excelDataList.toArray(new String[0][]);
    }

}
