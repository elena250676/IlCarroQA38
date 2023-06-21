import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @Test
    public void registrationPositive() {
        // open login form
        app.getUser().openLoginForm();
        // fill login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getUser().openRegistration();
        app.getUser().fillRegistrationForm("Elena" , "Pavlova","pavlovae435" + i + "@gmail.com", "Alex@2001");
        //app.getUser().fillCheckbox();
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }
    @AfterMethod
    public void tearDown() {

    }
}
