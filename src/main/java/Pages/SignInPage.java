package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private WebDriver driver;
    private By emailTextbox= By.xpath("//input[@id='email']");
    private By nextButton= By.xpath("//a[normalize-space()='Next']");

    public SignInPage(WebDriver driver){
        this.driver=driver;
    }
    public void SignInWithInvalidCredentials(String email) throws InterruptedException {
        By errorMessageElement= By.xpath("//div[@class='invalid-feedback']");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated((emailTextbox)));
        driver.findElement(emailTextbox).sendKeys(email);
        driver.findElement(nextButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated((errorMessageElement)));
        driver.findElement(errorMessageElement).isDisplayed();
    }
}
