import manager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    static AppManager app = new AppManager(
            System.getProperty("browser", BrowserType.CHROME)
    );
  //static   AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));
    @BeforeSuite(alwaysRun=true)
    public void Setup() throws IOException {
        app.init();
    }

    @AfterSuite(alwaysRun=true)
    public void stop(){
        app.tearDown();
    }
    @BeforeMethod(alwaysRun=true)
    public void startLogger(Method method){
        logger.info("Method " + method.getName() + " is started");
    }

    @AfterMethod(alwaysRun=true)
    public void end(){
        logger.info("==================================");
    }
}
