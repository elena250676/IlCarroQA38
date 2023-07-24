package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManager {
    Logger logger = LoggerFactory.getLogger(AppManager.class);
    //WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;
    HelperSearch search;

    Properties properties;


    public HelperSearch getSearch() {
        return search;
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperCar getCar() {
        return car;
    }

    public String getEmail() {
        return properties.getProperty("web.email");
    }

    public String getPassword() {
        return properties.getProperty("web.password");
    }

    String browser;

    public AppManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    @BeforeSuite
    public void init() throws IOException {
        String target = System.getProperty("target", "prod");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
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
        search = new HelperSearch(wd);
        //wd.manage().window().maximize();
        wd.navigate().to(properties.getProperty("web.baseURL"));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        // wd.quit();
    }
}
