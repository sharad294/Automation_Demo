//package com.cg.utils;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import com.cg.page.BasePage;
//
//public class CaptureScreen {
//
//	TakesScreenshot ts = (TakesScreenshot) BasePage.driver;
//	File ss=ts.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(ss, new File(".Screenshots/Snap.jpeg"));
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
