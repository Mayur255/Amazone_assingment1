package com.business_logic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DeviceCapb extends BaseClass {

	Properties prop = new Properties();
	public Properties OR;
	public File file = null;
	public FileReader filereader;

	private static String ANDROID_Device;
	private static String ANDROID_ID;
	private static String ANDROID_VERSION;
	private static String ANDROID_APP;
	private static String ANDROID_PKG_ID;
	private static String ANDROID_ACTIVITY_ID;

	public void loadCapabilities() throws IOException {

		OR = new Properties();
		file = new File(System.getProperty("user.dir") + "/resources/application.properties");

		filereader = new FileReader(file);

		OR.load(filereader);

		ANDROID_Device = OR.getProperty("android.deviceName");
		ANDROID_APP = OR.getProperty("android.app");
		ANDROID_ID = OR.getProperty("android.id");
		ANDROID_VERSION = OR.getProperty("android.version");
		ANDROID_PKG_ID = OR.getProperty("android.pkg.id");
		ANDROID_ACTIVITY_ID = OR.getProperty("android.activity.id");

	}

	public static void startAppium() throws IOException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("MobileCapabilityType.UDID,", "ANDROID_ID"); // Give Device ID of your mobile phone
		caps.setCapability("MobileCapabilityType.PLATFORM_NAME", "Android");
		caps.setCapability("MobileCapabilityType.PLATFORM_VERSION", "ANDROID_VERSION");
		caps.setCapability("MobileCapabilityType.APP", "ANDROID_APP");
		caps.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		caps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println("&&&&&&&&&&" + e.getMessage());
		}
	}
}