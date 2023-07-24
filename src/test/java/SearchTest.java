import manager.HelperSearch;
import models.Search;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    //    @Test(groups = {"regress", "positive"})
//    public void SearchFormDateManualPositive() throws Exception {
//        Search search = Search.builder()
//                .city("Tel Aviv")
//                .date("7/13/2023-7/30/2023")
//                .build();
//        app.getSearch().openSearchForm();
//        app.getSearch().fillSearchForm(search);
//        app.getSearch().submitSearchForm();
//    }
    @Test
    public void SearchPositiveSearch() {
        app.getSearch().fillSearchForm("Haifa", "07/16/2023", "03/19/2024");
        //app.getSearch().selectPeriodDaysDatePicker("7/16/2023","7/19/23");
        app.getSearch().pause(1000);
        app.getSearch().submitForm();
    }

}
