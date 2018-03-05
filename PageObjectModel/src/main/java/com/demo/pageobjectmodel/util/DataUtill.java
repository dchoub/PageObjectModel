package com.demo.pageobjectmodel.util;

import java.util.Hashtable;

public class DataUtill {

	
	public static Object[][] getData(Xls_Reader xls, String testCaseName){
		//Xls_Reader xls = new Xls_Reader (Constants.Data_Path);
		String sheetName = Constants.TESTDATA_SHEET;
		
		
		int testStartRowNum=1;
		System.out.println(xls.getCellData(sheetName, 0, testStartRowNum)); 
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
			testStartRowNum++;
		}
		System.out.println("Test starts from row - "+ testStartRowNum);
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		
		// calculate rows of data
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		System.out.println("Total rows are  - "+rows );
		
		//calculate total cols
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}
		System.out.println("Total cols are  - "+cols );
		Object[][] data = new Object[rows][1];
		//read the data
		int dataRow=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++){
				String key=xls.getCellData(sheetName,cNum,colStartRowNum);
				String value= xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
				
			}
			data[dataRow][0] =table;
			dataRow++;
		}
		return data;
		
	}
	
	
	public static boolean isTestExecutable(Xls_Reader xls, String testCaseName){
		int rows = xls.getRowCount(Constants.TESTCASE_SHEET);
		for (int r = 2; r<=rows; r++){
			String TestCase= xls.getCellData(Constants.TESTCASE_SHEET, "TCID",  r);
			if (TestCase.equals(testCaseName)){
				String runmode = xls.getCellData(Constants.TESTCASE_SHEET, "Runmode",  r);
				if (runmode.equals("Y")){
					return true;
					
				}
				else
					return false;
				
			}
		}
		return false;
		
	}
}
