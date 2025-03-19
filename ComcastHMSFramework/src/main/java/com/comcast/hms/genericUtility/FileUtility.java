package com.comcast.hms.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./ConfigAppData/CommonData.Properties");
	Properties prob=new Properties();
	prob.load(fis);
	String data=prob.getProperty(key);
	return data;	
}
}