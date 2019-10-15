import org.junit.Test;
import page.MainPage;

public class RefactoringTravelInsuranceTest extends BaseTest {

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem("Страхование путешественников");
    }
}
