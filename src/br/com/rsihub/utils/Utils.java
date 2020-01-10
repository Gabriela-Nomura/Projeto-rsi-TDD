//package br.com.rsihub.utils;
//
//import java.io.File;
//
//import utility.Constant;
//import utility.Log;
//import utility.TakesScreenshot;
//import utility.WebDriver;
//
//public class Utils {
//
//	
//	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
//		try{
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(scrFile, new File(constantes.Path_ScreenShot + sTestCaseName +".jpg"));	
//		} catch (Exception e){
//			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
//			throw new Exception();
//		}
//}
