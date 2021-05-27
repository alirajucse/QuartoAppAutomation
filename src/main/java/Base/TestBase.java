package Base;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
    private WebDriver driver;
    protected HomePage homePage;
    protected ContactUsPage contactUsPage;
    protected SignInPage signInPage;
    //private static String driverPath = "resource/geckodriver.exe";
    private static String driverPath = "resources\\";

    public WebDriver getDriver() {
        return driver;
    }
    private void setDriver(String browserType, String appURL) throws InterruptedException {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            case "edge":
                driver = initEdgeDriver(appURL);
                break;
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver(appURL);
        }
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome ..");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) throws InterruptedException {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        Thread.sleep(15000);
        return driver;
    }

    private static WebDriver initEdgeDriver(String appURL) throws InterruptedException {
        System.out.println("Launching edge browser..");
        System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        Thread.sleep(15000);
        return driver;
    }

    @Parameters({ "browserType", "appURL" })
    @BeforeClass(alwaysRun = true)
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            setDriver(browserType, appURL);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}


