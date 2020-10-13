package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider
{
	Properties pro;
	
	public ConfigDataProvider() throws FileNotFoundException
	{
		File src = new File("./Config/Config.properties");
		
		FileInputStream fis = new FileInputStream(src);
		
		pro = new Properties();
		
		try {
			pro.load(fis);
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			System.out.println("Not able to load config file >> " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public String  getDataFromConfig(String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}
	
	public String  getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String  getStagingURL()
	{
		return pro.getProperty("qaUrl");
	}
	
	
}
