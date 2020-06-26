package com.business_logic;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.AppiumDriver;

public class BaseClass {

	protected static AppiumDriver driver;
	public static String Get_ImageFilePath() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		String imagefilepath = "img2/" + formatter.format(date) + ".png";
		return imagefilepath;
	}

}
