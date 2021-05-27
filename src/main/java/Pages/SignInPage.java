package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private By emailTextbox= By.xpath("//input[@id='email']");
    private By nextButton= By.xpath("//a[normalize-space()='Next']");

    public SignInPage(WebDriver driver){
        this.driver=driver;
    }
    public void SignInWithInvalidCredentials(String email) throws InterruptedException {
        By errorMessageElement= By.xpath("//div[@class='invalid-feedback']");
        Thread.sleep(5000);
        driver.findElement(emailTextbox).sendKeys(email);
        driver.findElement(nextButton).click();
        Thread.sleep(10000);
        driver.findElement(errorMessageElement).isDisplayed();
    }
}
