package Tests;
import Base.TestBase;
import Pages.ContactUsPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;

public class ContactUsPageTest extends TestBase {
    private WebDriver driver=null;
    private ContactUsPage contactUsPage;
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        homePage=new HomePage(driver);
        contactUsPage=new ContactUsPage(driver);
    }
    @Parameters({ "name","email", "companyName","phone","message" })
    @Test(priority = 1,groups = { "smoke" })
    public void ContactUsFormTest(String name,String email,String companyName,String phone,String message) throws InterruptedException {
        homePage.contactUs();
        contactUsPage.submitContactUsForm(name,email,companyName,phone,message);
        contactUsPage.successfulSubmissionVerify();
    }
}
