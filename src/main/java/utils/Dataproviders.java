package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataproviders {
	
public static String[][] geta(String sheetname,String Keyword) throws IOException {
		//String[][] data =new String[1][4];
	//String[][] data=new String[1][20];

	//
	
	
	//
	
	
	FileInputStream fis = new FileInputStream(new File(sheetname));
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	//XSSFSheet sheet = workbook.getSheet(datasheetNo);	
	XSSFSheet sheet = workbook.getSheetAt(0);	
	// get the number of rows
	int rowCount = sheet.getLastRowNum();
	// get the number of columns
	int columnCount = sheet.getRow(0).getLastCellNum();
	//		data = new String[rowCount][columnCount];
	//	String email=s.getCell(0,i).getContents();
	////			
	// loop through the rows
	int colom = 0;
	for(int i=1; i <rowCount+1; i++){
		try {
XSSFRow row = sheet.getRow(i);
			String a=row.getCell(0).getStringCellValue();
			if(a.equalsIgnoreCase(Keyword)) {

				 colom =row.getLastCellNum(); 
				//sheet.getRow(i).getLastCellNum();
			//	System.out.println(+columnCount+ "dddddddddd");

			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	
	
	//System.out.println("*************" +colom);
	String[][] data=new String[1][colom];

	
	
	for(int i=1; i <rowCount+1; i++){
		try {

		XSSFRow row = sheet.getRow(i);
			String a=row.getCell(0).getStringCellValue();
			if(a.equalsIgnoreCase(Keyword)) {

				int columnct =row.getLastCellNum(); 
				//sheet.getRow(i).getLastCellNum();
			//	System.out.println(+columnCount+ "dddddddddd");

			//	String[][] data=new String[1][columnct];


				//*********
				for(int j=0; j <columnct; j++){ // loop through the columns

					//////////////////////
				
try {
						String cellValue = "";
					try {	
						//if(row.getCell(j).getCellType() == 1)
								cellValue = row.getCell(j).getStringCellValue();
				//			else if(row.getCell(j).getCellType() == 0)
					//			cellValue = ""+row.getCell(j).getNumericCellValue();
					}
					catch (NullPointerException e) {
						// TODO: handle exception
						System.out.println();
					}
							
							//System.out.println(cellValue);
							data[0][j]  = cellValue; // add to the data array
}
catch (Exception e) {
// TODO: handle exception
System.out.println("exception occur");
}
				}
			
			}
			
	}
	catch (Exception e) {
		// TODO: handle exception
	}
		
	workbook.close();
	
	
	
	}


//	System.out.println(data.length);

return data;

	

	}				

			

}
