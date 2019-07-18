package com.sgic.internal.employee.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.sgic.internal.employee.entities.Designation;
import com.sgic.internal.employee.entities.Employee;

public class ExcelUtils {

	@SuppressWarnings("unused")
	public static List<Employee> parseExcelFile(InputStream is) {
		try {
			System.out.println("excelutils2");
			Workbook workbook = new XSSFWorkbook(is);
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			// 1. You can obtain a sheetIterator and iterate over it
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			System.out.println("Retrieving Sheets using Iterator");
			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				System.out.println("=> " + sheet.getSheetName());
			}

			// Getting the Sheet at index zero
			Sheet sheet = workbook.getSheetAt(0);

			// Create a DataFormatter to format and get each cell's value as String
			DataFormatter dataFormatter = new DataFormatter();

			// 1. You can obtain a rowIterator and columnIterator and iterate over them
			System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
			Iterator<Row> rowIterator = sheet.rowIterator();
			List<Employee> lstCustomers = new ArrayList<Employee>();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// Now let's iterate over the columns of the current row
				Iterator<Cell> cellIterator = row.cellIterator();
				Employee cust = new Employee();
				Designation desi = new Designation();
				int cellIndex = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
//					String cellValue = dataFormatter.formatCellValue(cell);
					// System.out.print(cell + "\t");
					// System.out.print(cell + "\t");
					if (cellIndex == 0) { // ID
						System.out.print(cell + "\t");
						cust.setEmployeeid(cell.getStringCellValue());
					} else if (cellIndex == 1) { // Name
						System.out.print(cell + "\t");
						cust.setName(cell.getStringCellValue());
					} else if (cellIndex == 2) { // Address
						System.out.print(cell + "\t");
						cust.setEmail(cell.getStringCellValue());
					} else if (cellIndex == 3) { // Address
						System.out.print(cell + "\t");
						desi.setDesignationid((long) cell.getNumericCellValue());
						// employeeDto.setDesignationid(employee.getDesignation().getDesignationid());
						cust.setDesignation(desi);
					}

					cellIndex++;
				}
				lstCustomers.add(cust);

			}

			// Close WorkBook
			workbook.close();

			// return lstCustomers;
			return lstCustomers;
		} catch (IOException e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}

	}

}