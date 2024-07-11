package ExcelUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Excel_Utility_Download {
    public ArrayList<String> getData(String testcasename, String sheet_name) throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")  + File.separator +"src" + File.separator +"test"+ File.separator +"java" + File.separator +"resources" + File.separator +"PNC_1.0_Download.xlsx");


        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheets = workbook.getNumberOfSheets();

        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheet_name)) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //Identify Testcases coloum by scanning the entire 1st row
                Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();//row is collection of cells
                int k = 0;
                int coloumn = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();

                    if (value.getStringCellValue().equalsIgnoreCase("TestCase")) {
                        coloumn = k;
                    }
                    k++;
                }
                System.out.println(coloumn);
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasename)) {
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            a.add(cv.next().getStringCellValue());
                        }
                    }
                }

            }
        }

        for (Object d:a){
            System.out.println((String)(d));
        }

        return a;
    }
}



