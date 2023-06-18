import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LolinTests extends TestBase {
    @Test
    public void loginPositive() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("pavlovae434@gmail.com", "Alex@2001");
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
    @AfterMethod
    public void tearDown() {
        //wd.quit();

    }
}