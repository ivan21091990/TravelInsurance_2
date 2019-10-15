package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurancePage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Оформить онлайн')]")
    public WebElement sendAppBtn;

    @FindBy(xpath = "//a[contains(@target, '_blank')]//img")
    public WebElement arrangeOnlineBtn;

    public TravelInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /*public void waitSendAppClickable(){
        WebElement sendBtn = driver.findElement(By.xpath("//span[contains(text(),'Оформить онлайн')]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, 30,1000);
        wait.until(ExpectedConditions.visibilityOf(sendBtn)).click();
    }*/
}

