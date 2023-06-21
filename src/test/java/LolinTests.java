import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LolinTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()==true) {
            app.getUser().logout();


        }
    }

    @Test
    public void loginPositive() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("pavlovae434@gmail.com", "Alex@2001");
        app.getUser().submitLogin();
        app.getUser().clickOK();
        app.getUser().logout();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }




    @Test
    public void loginPositiveUserData() {
        // User user = new User("pavlovae434@gmail.com", "Alex@2001");
        User user = new User().withEmail("pavlovae434@gmail.com").withPassword("Alex@20");

//        user.setEmail("pavlovae434@gmail.com");
//        user.setPassword("Alex@2001");
        //       user.setEmail("pavlovae434@gmail.com");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void loginPositiveUser() {
        // User user = new User("pavlovae434@gmail.com", "Alex@2001");
        User user = new User().withEmail("pavlovae434@gmail.com").withPassword("Alex@20");

//        user.setEmail("pavlovae434@gmail.com");
//        user.setPassword("Alex@2001");
        //       user.setEmail("pavlovae434@gmail.com");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

//    @Test
//    public void loginNegativeWrongEmail() {
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm("pavlovae434gmail.com", "Alex@2001");
//        app.getUser().submitLogin();
//        app.getUser().pause(3000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
//    }
@AfterMethod
    public void tearDown() {
        //wd.quit();

    }
}