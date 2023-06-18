import manager.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  static   AppManager app = new AppManager();
    @BeforeSuite
    public void Setup(){
        app.init();
    }

    @AfterSuite
    public void stop(){
        app.tearDown();
    }
}
