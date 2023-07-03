import manager.TestNGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNGListener.class)
public class RegistrationTests extends TestBase {
    @BeforeMethod

    public void precondition(){
        if(app.getUser().isLogged()) app.getUser().logout();
    }
    @Test
    public void registrationPositive1(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("john_" + i + "@mail.com")
                .withPassword("$Asdf1234");

        app.getUser().openRegistrationForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitLogin();
        logger.info("submitLogin invoked");
        logger.info("registrationPositive starts with credentials: login "
                + user.getEmail() + " & password: " + user.getPassword());
        Assert.assertTrue(app.getUser().isLoggedSuccess());


    }
    @Test
    public void registrationNegativ(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
              .withName("John")
              .withLastName("Snow")
              .withEmail("john_" + i + "mail.com")
              .withPassword("Alex@2001");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertFalse(app.getUser().isLoggedSuccess());
    }
    @Test
    public void registrationPositive() {
        // open login form
        app.getUser().openLoginForm();
        // fill login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getUser().openRegistration();
        app.getUser().fillRegistrationForm("Elena" , "Pavlova","pavlovae435" + i + "@gmail.com", "Alex@2001");
        app.getUser().fillCheckbox();
        app.getUser().submitRegistration();
        app.getUser().pause(5000);

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }
    @AfterMethod
    public void tearDown() {

    }
}
