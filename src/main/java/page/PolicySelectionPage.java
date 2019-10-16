package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PolicySelectionPage extends BasePage {

    @FindBy(xpath = "//*[text()='Минимальная']/../..")
    WebElement minBtn;

    @FindBy(xpath = "//span[text()='Оформить']")
    public WebElement issueBtn;

    public PolicySelectionPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void waitMinBtnClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[text()='Минимальная']/../..")))).click();
    }

}
