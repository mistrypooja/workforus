package test.java.com.assignment.base;

import java.util.List;

public interface IRuntimeConfig{

	public boolean runLocal=false;
	public String appUrl=null;
	public String[] testableBrowsers=null;	
	String getAppUrl();	
	List<String> getTestableBrowsersList();
	public boolean getRunLocal();
	public boolean getHeadless();
	public String getSaucelabsUserName();
	public String getSaucelabsKey();

}
