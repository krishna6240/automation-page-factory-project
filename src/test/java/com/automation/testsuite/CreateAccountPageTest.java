package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignINPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Listeners(CustomListeners.class)
public class CreateAccountPageTest extends TestBase {
    HomePage homePage;
    SignINPage signINPage;
    CreateAccountPage createAccountPage;
    SoftAssert softAssert;
    String timeStamp ;

    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void inTt() {
        homePage = new HomePage();
        signINPage = new SignINPage();
        softAssert = new SoftAssert();
        createAccountPage = new CreateAccountPage();
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully()
    {
        homePage.setClickOnSignInLink();
        signINPage.setClickOnCreateAnAccount("abc"+timeStamp+"@gmail.com");
        createAccountPage.fillPersonalInformationForm("Krishna","Patel","abc1234");
        createAccountPage.fillYourAddressDetails("1 Nice Building","Harrow","London","02345","UK","0123456789","main home");
        String expectedTest= "My account";
        String actualTest= createAccountPage.verifyMyAccountText();
        softAssert.assertEquals(expectedTest,actualTest);
        softAssert.assertAll();
    }


}

