# Warung Pintar Assessment

### Created By: Gradito Tunggulcahyo


This project is based on Selenium and TestNG data driven using Excel File.

There are 2 Test Suites available for this Project:

1. Ebay: Access a Product via category after applying multiple filters --> ebay_TestSuites.xml

2. Gist Github --> gistGithub_TestSuites.xml

For Login data, you can edit on Excel File.

Excel File located in "data" folder, so you can change the username and password also another fields.

Each Excel File linked to one kind Scenario.

Test Case on each Test Suite will explain below:

----

- ebay_TestSuites.xml will contain 1 Test Case:

	1. Access a Product via category after applying multiple filters

And the Test Data located in: **data/ebayData.xlsx**

---

- gistGithub_TestSuites.xml will contain 4 Test Cases:

	1. As a user, I want to create a public gist.

	2. As a user, I want to edit an existing gist.

	3. As a user, I want to delete an existing gist.

	4. As a user, I want to see my list of gists.

And the Test Data located in: **data/gistGithubData.xlsx**

**Please make sure the login data filled on each sheets before you run the test suite!!!**

## Notes:

1. All libs are included in this repository

2. Chrome Driver and Gecko Driver are included too, for Windows x64 and Mac

	- chromedriver version is for Chrome Browser 81.x 

	- geckodriver versiion is v26.0 and minimum required Firefox version is Firefox 60

3. You can update chromedriver and geckodriver if the execution failed to open the browser

	- chromedriver: https://chromedriver.chromium.org/downloads

	- geckodriver: https://github.com/mozilla/geckodriver/releases