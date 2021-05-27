package Tests;
import Base.TestBase;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    private HomePage homePage;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        homePage=new HomePage(driver);
    }
    @Test(priority = 1,groups = { "Home","smoke" })
    public void LandingHomePageTest() throws InterruptedException {
        System.out.println("Home page test...");
        homePage.landHomePageVerify();
    }
    @Test(priority = 2,groups = { "Home","smoke" })
    public void FeaturesMenuItemTest() throws InterruptedException {
        homePage.clickFeaturesMenuItem();
    }
    @Test(priority = 3,groups = { "Home","smoke" })
    public void IndustriesMenuItemTest() throws InterruptedException {
        homePage.clickIndustriesMenuItem();
    }
    @Test(priority = 4,groups = { "Home","smoke" })
    public void PricingMenuItemTest() throws InterruptedException {
        homePage.clickPricingMenuItem();
    }
    @Test(priority = 5,groups = { "Home","smoke" })
    public void BlogMenuItemTest() throws InterruptedException {
        homePage.clickBlogMenuItem();
    }
    @Test(priority = 6,groups = { "Home","smoke" })
    public void SignInMenuItemTest() throws InterruptedException {
        homePage.clickLogInMenuItem();
    }
}
