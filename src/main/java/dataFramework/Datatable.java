package dataFramework;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Datatable {

    static String path;

    Workbook workbook;

    Sheet sheet;

    Row  row;

    static FileInputStream fis;

    public Datatable(String path){
        Datatable.path = path;
    }

    public void createConnection() throws Exception {
        File file = new File(path);

        fis = new FileInputStream(file);

        workbook = new HSSFWorkbook(fis);

        sheet = workbook.getSheetAt(0);
    }

    public String getDataFromExcel(String rowName, String colName) throws IOException {

        int dataRowNum = -1;
        int dataColNum = -1;

        int totalRows = sheet.getLastRowNum();

        for(int i=0; i<=totalRows; i++){

            if(sheet.getRow(i).getCell(0).getStringCellValue().equals(rowName)){
                System.out.println("Row match is found");

                dataRowNum = i;
                break;
            }
        }

        for(int j=0; j<sheet.getRow(0).getPhysicalNumberOfCells(); j++){

            if(sheet.getRow(0).getCell(j).getStringCellValue().equals(colName)){
                dataColNum = j;
                break;
            }

        }

        String op = sheet.getRow(dataRowNum).getCell(dataColNum).getStringCellValue();

        fis.close();
        return op;
    }

}
