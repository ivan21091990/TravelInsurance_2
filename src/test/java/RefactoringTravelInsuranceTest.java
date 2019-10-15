import org.junit.Test;
import page.MainPage;
import page.PolicySelectionPage;
import page.SendAppPage;
import page.TravelInsurancePage;

public class RefactoringTravelInsuranceTest extends BaseTest {

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem("Страхование путешественников");

       TravelInsurancePage travelInsurancePage =  new TravelInsurancePage(driver);
       travelInsurancePage.waitSendAppClickable();
       travelInsurancePage.arrangeOnlineBtn.click();

       TabNavigation();
       PolicySelectionPage policySelectionPage = new PolicySelectionPage(driver);
       policySelectionPage.waitMinBtnClickable();
       policySelectionPage.issueBtn.click();

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Фамилия застрахованного", "Ivanov");
        sendAppPage.fillField("Имя застрахованного", "Ivan");
        sendAppPage.fillField("Дата рождения застрахованного", "21091990");
        sendAppPage.fillField("Фамилия страхователя", "Сергеев");
        sendAppPage.fillField("Имя страхователя", "Сергей");
        sendAppPage.fillField("Отчество страхователя", "Сергеевич");
        sendAppPage.fillField("Дата рождения страхователя", "01011985");

        sendAppPage.floorRadBtn.click();

        sendAppPage.fillField("Ivanov", "Фамилия застрахованного");
        sendAppPage.fillField("Ivan", "Имя застрахованного");
        sendAppPage.fillField("21.09.1990","Дата рождения застрахованного");
        sendAppPage.fillField("Сергеев","Фамилия страхователя");
        sendAppPage.fillField("Сергей","Имя страхователя");
        sendAppPage.fillField("Сергеевич","Отчество страхователя");
        sendAppPage.fillField("01.01.1985","Дата рождения страхователя");

        sendAppPage.sendButton.click();

        sendAppPage.checkFieldErrorMessage("'Заполнены не все обязательные поля");
    }
}
