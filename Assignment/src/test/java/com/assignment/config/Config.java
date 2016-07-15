package test.java.com.assignment.config;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class Config {

	public Boolean runLocal=true;
	public String appURL="http://civihr-staging.civihrhosting.co.uk";
	public List<String> testableBrowsers=new ArrayList<String>();
	public List<String> companyURLList =  new ArrayList<String>();
	public String saucelabsUserName="username";
	public String saucelabsKey="key";
	public boolean isHeadless=false;

	public Config(){

		testableBrowsers.add("firefox");
		testableBrowsers.add("44");
		testableBrowsers.add("WINDOWS");
		testableBrowsers.add("600");

	}
}
