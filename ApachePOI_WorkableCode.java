package urlExcercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ApachePOI_WorkableCode {

	WebDriver driver;

	public static ArrayList<String> m1(String filepath, int sheetNumber, int columnNumber) throws Exception {

		File f = new File(filepath);
		FileInputStream is = new FileInputStream(f);
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		ArrayList<String> list = new ArrayList<String>();
	

		HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			list.add(rowIterator.next().getCell(columnNumber).getStringCellValue());
			
		}
		return list;

	}
	
	
		
		@Test
		public void dataDriven() throws Exception {
		driver=null;
		System.setProperty(null, null);
		ArrayList userName = m1(0,0);
		ArrayList passWord = m1(0,1);
		
		/*if you have more fields to pass then invoke the above method by m1(0,2) 0 being the sheet Index and 2 being the column index ie. column number 3
		Column 1| Column 2| Column 3|
		Index  0| Index  1| Index  2|
	ex.	userId  | password| email   |
		*/
		for (int i = 0; i < userName.size(); i++) {
			
			System.out.println(userName.get(i)+" | "+passWord.get(i));
		
//		driver.findElement(By.id("email")).sendKeys(userName).get(i);
//		driver.findElement(By.id("pass")).sendKeys(passWord).get(i);
//		driver.findElement(By.id("submitButton")).sendKeys(Keys.ENTER); //instead of using the click() method I used this cause I'm lazy.
		}}
			
}