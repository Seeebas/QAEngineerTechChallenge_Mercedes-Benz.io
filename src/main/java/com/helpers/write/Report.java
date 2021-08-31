package com.helpers.write;

import com.helpers.constants.Constants;
import com.helpers.utils.FilesUtils;
import com.helpers.utils.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Report {

    private final static Logger logger = Logger.getLogger(Report.class.getName());

    public static void write(String... values){

        try{

            FileInputStream excel = null;

            XSSFWorkbook workbook = null;
            XSSFSheet sheet = null;

            int rowNumber = 0;
            Row newRow = null;

            String path = StringUtils.concatenate(
                    System.getProperty(Constants.USER_DIR),
                    Constants.DASH,
                    Constants.FOLDER_REPORT,
                    Constants.DASH,
                    Constants.REPORT_EXEL_NAME);

            if(FilesUtils.fileExist(path)){
                excel = new FileInputStream(path);
                workbook = new XSSFWorkbook(excel);
                sheet = workbook.getSheet(Constants.FOLDER_REPORT);
            }else{

                new File(path).createNewFile();
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet(Constants.FOLDER_REPORT);

                createExcelHeaders(sheet);
            }

            rowNumber = sheet.getLastRowNum();
            newRow = sheet.createRow(++rowNumber);
            int cellNum = 0;

            for (String value:values) {
                Cell cell = newRow.createCell(cellNum);
                cell.setCellValue(value);
                sheet.autoSizeColumn(cellNum++);

            }

            FileOutputStream out = new FileOutputStream(path);
            workbook.write(out);
            out.close();

        }catch (NullPointerException | IOException e){
            logger.log(Level.WARNING,"An error occurred while trying to generate report " + e.getMessage());
        }

    }

    private static void createExcelHeaders(XSSFSheet sheet) {

        Row header = sheet.createRow(0);
        int cellNum = 0;

        for (String value : Constants.getExcelHeaders()) {
            Cell cell = header.createCell(cellNum++);
            cell.setCellValue(value);
        }
    }

}
