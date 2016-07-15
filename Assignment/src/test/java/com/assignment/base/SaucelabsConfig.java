package test.java.com.assignment.base;

import java.util.List;

import test.java.com.assignment.config.Config;

public class SaucelabsConfig implements IRuntimeConfig{

	Config config= null;
	
	public SaucelabsConfig (Config config){
		this.config=config;
	}

	public String getAppUrl()
	{
		return config.appURL;
	}

	public List<String> getTestableBrowsersList()
	{
		return config.testableBrowsers;
	}

	public List<String> getCompanyURLList(){
		return config.companyURLList;
	}

	public boolean getRunLocal(){
		return config.runLocal;
	}
	
	public String getSaucelabsUserName(){
		return config.saucelabsUserName;
	}
	
	public String getSaucelabsKey(){
		return config.saucelabsKey;
	}
	
	public boolean getHeadless(){
		return config.isHeadless;
	}

}
