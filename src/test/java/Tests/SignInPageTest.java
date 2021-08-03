package Tests;
import Base.TestBase;
import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.*;

public class SignInPageTest extends TestBase{
    private WebDriver driver;
    private SignInPage signInPage;
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        signInPage=new SignInPage(driver);
        homePage=new HomePage(driver);
    }
    @Parameters({ "email" })
    @Test(priority = 1,groups = { "smoke" })
    public void TrySignInWithWrongCredentialsTest(String email) throws InterruptedException {
        homePage.clickLogInMenuItem();
        signInPage.SignInWithInvalidCredentials(email);
    }
}
