import manager.ProviderData;
import manager.TestNGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class LolinTests extends TestBase {
    @BeforeMethod

    public void precondition() {
        if (app.getUser().isLogged()) app.getUser().logout();
    }

    @Test

    public void loginPositive() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("pavlovae434@gmail.com", "Alex@2001");
        app.getUser().submitLogin();
        // app.getUser().clickOK();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }


    @Test

    public void loginPositiveUserData() {
        // User user = new User("pavlovae434@gmail.com", "Alex@2001");
        User user = new User()
                .withEmail("pavlovae434@gmail.com")
                .withPassword("Alex@2001");

//        user.setEmail("pavlovae434@gmail.com");
//        user.setPassword("Alex@2001");
//        user.setEmail("pavlovae434@gmail.com");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
        @Test
        public void loginPositiveUser () {
            // User user = new User("pavlovae434@gmail.com", "Alex@2001");
            User user = new User().withEmail("pavlovae434@gmail.com").withPassword("Alex@2001");

//        user.setEmail("pavlovae434@gmail.com");
//        user.setPassword("Alex@2001");
            //       user.setEmail("pavlovae434@gmail.com");
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
            app.getUser().submitLogin();
            app.getUser().pause(3000);
            Assert.assertTrue(app.getUser().isLoggedSuccess());
        }
        @Test
        public void loginPositiveProps () {
            // User user = new User("pavlovae434@gmail.com", "Alex@2001");
            // User user = new User().withEmail(app.getEmail()).withPassword(app.getPassword());

//        user.setEmail("pavlovae434@gmail.com");
//        user.setPassword("Alex@2001");
            //       user.setEmail("pavlovae434@gmail.com");
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(app.getEmail(), app.getPassword());
            app.getUser().submitLogin();
            //app.getUser().pause(3000);
            Assert.assertTrue(app.getUser().isLoggedSuccess());
        }

    @Test(dataProvider = "userDto", dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user) {
//        User user = new User()
//                .withEmail("asd@fgh.com")
//                .withPassword("$Asdf1234")
//                ;
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
//
    @Test(dataProvider = "userDtonegative", dataProviderClass = ProviderData.class)


    public void loginNegativeUserDTO(User user) {
//        User user = new User()
//                .withEmail("asd@fgh.com")
//                .withPassword("$Asdf1234")
//                ;
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
        //app.getUser().clickOkButton();
        //app.getUser().logout();
    }
//
//    @Test
//    public void loginNegativeWrongEmail() {
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm("pavlovae434gmail.com", "Alex@2001");
//        app.getUser().submitLogin();
//        app.getUser().pause(3000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
//    }

        @AfterMethod

        public void postcondition () {
            app.getUser().clickOkButton();
        }
    }
