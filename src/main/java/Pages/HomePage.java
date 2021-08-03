package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private By acceptCookiesButton= By.xpath("//button[normalize-space()='Accept']");
    private By featuresMenuItemLink= By.xpath("//a[normalize-space()='features']");
    private By industiesMenuItem= By.xpath("//a[normalize-space()='industries']");
    private By pricingMenuItemLink= By.xpath("//a[normalize-space()='pricing']");
    private By blogMenuItemLink= By.xpath("//a[normalize-space()='blog']");
    private By signInButton= By.xpath("//a[normalize-space()='Sign In']");
    private By industriesPageVerifyElement= By.xpath("//h1[contains(text(),'Elevate')]");
    private By employeePageVerifyElement= By.xpath("//span[normalize-space()='Employee Recognition']");
    private By pricingPageVerifyElement= By.xpath("//section[@id='pricing']//div[2]//p[1]");
    private By signInPageVerifyElement= By.xpath("//h1[normalize-space()='Log In']");
    private By contactUsButton= By.xpath("//a[@class='btn btn-ghost']");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void landHomePageVerify() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated((acceptCookiesButton)));
        driver.findElement(acceptCookiesButton).click();
        String expectedPageTitle = "Quarto";
        String title= driver.getTitle();
        Assert.assertEquals(title,expectedPageTitle);
    }
    public void clickFeaturesMenuItem() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated((featuresMenuItemLink)));
        driver.findElement(featuresMenuItemLink).click();
        if(driver.findElement(employeePageVerifyElement).isDisplayed()){
            System.out.println("Test case passed");
        }
        else
        {
            System.out.println("Test case failed");
        }
    }
    public void clickIndustriesMenuItem() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated((industiesMenuItem)));
        driver.findElement(industiesMenuItem).click();
    }
    public void clickPricingMenuItem() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated((pricingMenuItemLink)));
        driver.findElement(pricingMenuItemLink).click();
        if(driver.findElement(pricingPageVerifyElement).isDisplayed()){
            System.out.println("Test case passed");
        }
        else
        {
            System.out.println("Test case failed");
        }
    }
    public void clickBlogMenuItem() throws InterruptedException {
        String blogPagerTitle="Blog | Quartolab – Most advanced enterprise knowledge management system exclusively designed for the construction and development industry";
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated((blogMenuItemLink)));
        driver.findElement(blogMenuItemLink).click();
        String winHandleBefore = driver.getWindowHandle();
        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Assert.assertEquals(blogPagerTitle,"Blog | Quartolab – Most advanced enterprise knowledge management system exclusively designed for the construction and development industry");
        driver.switchTo().window(winHandleBefore);
    }
    public void clickLogInMenuItem() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated((signInButton)));
        driver.findElement(signInButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated((signInPageVerifyElement)));
        if(driver.findElement(signInPageVerifyElement).isDisplayed()){
            System.out.println("Test case passed");
        }
        else
        {
            System.out.println("Test case failed");
        }
    }
    public void contactUs() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated((contactUsButton)));
        driver.findElement(contactUsButton).click();
    }
}
