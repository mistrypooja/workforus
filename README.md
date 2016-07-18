
# Manual tests

I have written and test plan and executed the tests as per the plan. I have recorded a video for every test that I performed and updated it in the “Actual Result” section of the spreadsheet.

# Automated tests

I have developed the asked automated tests using Selenium webdriver and testNG framework. The framework as is takes into account the requirement to run the tests on saucelabs. The way I have committed them, I have configured to run them locally. In order to run them on saucelabs, the config file needs to be updated.

In order to run the tests, you will need gradle installed. Open the Assignment folder in command line and run the command "gradle cleanTest test"
I have used the latest version of selenium and it should work with any firefox you have installed. In case the tests fail to connect, you may need to upgrade to firefox 46 and try running them.
