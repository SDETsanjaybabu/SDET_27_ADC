package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author SanjayBabu
 *
 */
public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String getPropertyKeyValue(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./data/tiger.properties");
	Properties pbj = new Properties();
	pbj.load(fis);
	String value = pbj.getProperty(key);
	return value;
}
}
