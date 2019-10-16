import org.junit.Test;
import page.MainPage;
import page.PolicySelectionPage;
import page.SendAppPage;
import page.TravelInsurancePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

        sendAppPage.checkFillField("Ivanov",   "Фамилия застрахованного");
        sendAppPage.checkFillField("Ivan", "Имя застрахованного");
        sendAppPage.checkFillField("21.09.1990","Дата рождения застрахованного");
        sendAppPage.checkFillField("Сергеев","Фамилия страхователя");
        sendAppPage.checkFillField("Сергей","Имя страхователя");
        sendAppPage.checkFillField("Сергеевич","Отчество страхователя");
        sendAppPage.checkFillField("01.01.1985","Дата рождения страхователя");

        sendAppPage.sendButton.click();

        sendAppPage.checkFieldErrorMessage("Заполнены не все обязательные поля");
    }
}
