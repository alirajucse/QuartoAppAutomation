package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;

public class ContactUsPage {
    private WebDriver driver;
    private By nameTextbox= By.xpath("//input[@id='name']");
    private By emailTextbox= By.xpath("//input[@id='email']");
    private By companyNameTextbox= By.xpath("//input[@id='companyname']");
    private By phoneNumberTextbox= By.xpath("//input[@id='phonenumber']");
    private By messageTextbox= By.xpath("//textarea[@id='message']");
    private By submitButton= By.xpath("//button[@id='submit-request-demo']");
    private By successfulFormSubmitVerifyElement= By.xpath("//h1[normalize-space()='Thank you for contacting us.']");

    public ContactUsPage(WebDriver driver){
        this.driver=driver;
    }
    public void submitContactUsForm(String name,String email,String companyName,String phone,String message) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(nameTextbox).sendKeys(name);
        driver.findElement(emailTextbox).sendKeys(email);
        driver.findElement(companyNameTextbox).sendKeys(companyName);
        driver.findElement(phoneNumberTextbox).sendKeys(phone);
        driver.findElement(messageTextbox).sendKeys(message);
        driver.findElement(submitButton).click();
    }
    public void successfulSubmissionVerify() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(successfulFormSubmitVerifyElement).isDisplayed();
    }
}
