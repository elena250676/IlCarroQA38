package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class AppManager {
    Logger logger = LoggerFactory.getLogger(AppManager.class);
    //WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;

    public HelperUser getUser() {
        return user;
    }

    public HelperCar getCar() {
        return car;
    }

    String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }

    @BeforeSuite
    public void init() {
        if (browser.equals(BrowserType.CHROME)) ;
        {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests starting on Chrome");
        }
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests starting on Firefox");
        }
       // wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new WebDriverListener());
        user = new HelperUser(wd);
        car = new HelperCar(wd);
        //wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        // wd.quit();
    }
}
