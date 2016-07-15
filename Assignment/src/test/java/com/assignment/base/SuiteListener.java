package test.java.com.assignment.base;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import test.java.com.assignment.config.Config;

public class SuiteListener implements ISuiteListener{

	@Override
	public void onFinish(ISuite arg0) {		

	}

	@Override
	public void onStart(ISuite arg0) {

		final IRuntimeConfig config = new SaucelabsConfig(new Config());
		IDriverFactory saucelabsDriver = new SaucelabsDriverFactory(config);
		DesiredCapabilities capabillities = null;

		saucelabsDriver.setConfig(config);
		if(!saucelabsDriver.getConfig().getRunLocal()){
			if(config.getTestableBrowsersList().get(0).equals("firefox")){
				capabillities = DesiredCapabilities.firefox();
			}
			else if(config.getTestableBrowsersList().get(0).equals("chrome")){
				capabillities = DesiredCapabilities.chrome();
			}
			else if(config.getTestableBrowsersList().get(0).equals("ie")){
				capabillities = DesiredCapabilities.internetExplorer();
			}
			else if(config.getTestableBrowsersList().get(0).equals("edge")){
				capabillities = DesiredCapabilities.edge();
			}
			capabillities.setCapability("version", config.getTestableBrowsersList().get(1));
			capabillities.setCapability("platform", config.getTestableBrowsersList().get(2));
			capabillities.setCapability("resolution", "1920x1080");
			capabillities.setCapability("name", "username");
			capabillities.setCapability("max-duration", config.getTestableBrowsersList().get(3)); 
			saucelabsDriver.setCapabilities(capabillities);

		}

	}

}
