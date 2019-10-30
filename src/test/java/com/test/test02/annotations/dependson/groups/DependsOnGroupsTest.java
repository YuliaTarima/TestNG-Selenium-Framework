package com.test.test02.annotations.dependson.groups;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class DependsOnGroupsTest extends BaseTest {
	
/*
 * Simple demonstration of test start
 * depending on success of a previous group.
 * E.g., user login should not happen without DB connection and launching the browser 
 * 
 * soft Dependency (alwaysRun=true) dependent test will run even on failure of a previous test
 */
    
	@Test(groups="init")
    public void creatingDBConn() {
	System.out.println("\n###################\n Init Group: Creating DB connection \n###################");
    }

    @Test (groups="init")
    public void launchBrowser() {
	System.out.println("\n###################\n Init Group: Launching browser \n###################");
	Assert.fail("launchBrowser failed");
    }

    @Test(dependsOnGroups = "init", groups = {"mainflow"})
    public void doUserRegistration() {
	System.out.println("\n###################\n Mainflow Group: Executing user registration test\n"+"Depends on init \n###################");

    }

    @Test(groups = "mainflow")
    public void doUserLogin() {
	System.out.println("\n###################\n Mainflow Group: Executing login test \n###################");
    }

    @Test(dependsOnGroups = "init", alwaysRun = true, groups = "mainflow")
    public void thirdTest() {
	System.out.println("\n###################\n Mainflow Group, alwaysRun: Executing third test \n"+"Depends on init group, with soft depenedency alwaysRun \n###################");
    }

    @Test(groups="mainflow")
    public void fourthTest() {
	System.out.println("\n###################\n Mainflow Group: Executing Build Verification Test \n###################");
    }
    
    @Test(dependsOnGroups = {"init", "mainflow"}, groups="teardown")
    public void closeBrowser() {
	System.out.println("\n###################\n Teardown Group: Closing browser\n"+"Depends on init and mainflow \n###################");
    }
    
    @Test(groups="teardown")
    public void closingDBConn() {
	System.out.println("\n###################\n Teardown Group: Closing DB connection \n###################");
    }


}
