package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendAppPage extends BasePage {

    @FindBy(xpath = "//*[text()='Минимальная']/../..")
    WebElement minBtn;

    @FindBy(xpath = "//span[text()='Оформить']")
    WebElement issueBtn;

    @FindBy(xpath = "//input[@name='insured0_surname']")
    WebElement insuredSurName;

    @FindBy(xpath = "//input[@name='insured0_name']")
    WebElement insuredName;

    @FindBy(xpath = "//input[@name='insured0_birthDate']")
    WebElement insuredBirthDate;

    @FindBy(xpath = "//input[@name='surname']")
    WebElement surName;

    @FindBy(xpath = "//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "//input[@name='middlename']")
    WebElement middleName;

    @FindBy(xpath = "//input[@name='birthDate']")
    WebElement birthDate;

    @FindBy(xpath = "//input[@name='male']")
    WebElement floorRadBtn;

    @FindBy(xpath = "/span[text()='Продолжить']")
    public WebElement sendButton;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия застрахованного":
                fillField(insuredSurName, value);
                break;
            case  "Имя застрахованного":
                fillField(insuredName, value);
                break;
            case  "Дата рождения застрахованного":
                fillField(insuredBirthDate, value);
                break;
            case  "Фамилия страхователя":
                fillField(surName, value);
                break;
            case  "Имя страхователя":
                fillField(name, value);
                break;
            case  "Отчество страхователя":
                fillField(middleName, value);
                break;
            case  "Дата рождения страхователя":
                fillField(birthDate, value);
                break;
            case  "Пол страхователя":
                fillField(floorRadBtn, value);
                break;
            default:
                throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
}
