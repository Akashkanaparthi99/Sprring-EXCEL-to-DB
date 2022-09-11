package com.employee.utility;

import com.employee.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author AkashKanaparthi
 * @Date - 27-05-2022
 * @Project - Buddy_Assignments
 * @name - ExcelHelper
 */
public class ExcelHelper {

    static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    /**
     * checks that file is of excel type or not
     * @param multipartFile
     * @return boolean (true or false)
     */
    public static boolean checkExcelFormat(MultipartFile multipartFile){
        String contentType = multipartFile.getContentType();
        return contentType.equals(TYPE);
    }

    /**
     * it converts the excel sheet data to list of data
     * @param inputStream
     * @return list of employees
     */
    public static List<Employee> convertExcelToList(InputStream inputStream){
        List<Employee> employees = new ArrayList<>();
        try {
            // complete file that was uploaded
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            // gets the single sheet with name
            XSSFSheet sheet = workbook.getSheet("EmployeeDetails");
            // we are iterating through the row's from the sheet
            int rowNumber = 0;
            Iterator<Row> rowIterator = sheet.iterator();

            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                if (rowNumber==0){
                    rowNumber++;
                    continue;
                }

                // from single cell we now iterate through the cell
                Iterator<Cell> cellIterator = row.iterator();

                int cellId = 0;

                Employee employee = new Employee();

                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();

                    switch (cellId){
                        case 0:
                            employee.setEmployeeId((int)cell.getNumericCellValue());
                            break;
                        case 1:
                            employee.setFirstName(cell.getStringCellValue());
                            break;
                        case 2:
                            employee.setLastName(cell.getStringCellValue());
                            break;
                        case 3:
                            employee.setEmailId(cell.getStringCellValue());
                            break;
                        case 4:
                            employee.setMobile((long) cell.getNumericCellValue());
                            break;
                        case 5:
                            employee.setCity(cell.getStringCellValue());
                            break;
                        case 6:
                            employee.setState(cell.getStringCellValue());
                            break;
                        case 7:
                            employee.setRole(cell.getStringCellValue());
                            break;
                        case 8:
                            employee.setDepartment(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellId++;
                }
                employees.add(employee);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }
}
