package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        wd.findElement(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']")).click();
    }
    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
    public void fillLoginForm(User user){
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }
//    public void fillLoginForm(String password, String email,){
//        type(By.xpath("//input[@id='email']"), email);
//        type(By.xpath("//input[@id='password']"), password);
//    }
public void openRegistration(){
    wd.findElement(By.xpath("//span[@class='navigator']")).click();
}
public void fillRegistrationForm(String firstname, String lastname, String email, String password) {
    type(By.xpath("//input[@id='name']"), firstname);
    type(By.xpath("//input[@id='lastName']"), lastname);
    type(By.xpath("//input[@id='email']"), email);
    type(By.xpath("//input[@id='password']"), password);
}

public void fillCheckbox() {

    WebElement CheckboxSelected = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
    boolean isSelected = CheckboxSelected.isSelected();

    // performing click operation if element is not selected
		if(isSelected == false) {
        CheckboxSelected.click();
    }

    /**
     * Validate isDisplayed and click
     */
    WebElement checkBoxDisplayed = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
    boolean isDisplayed = checkBoxDisplayed.isDisplayed();

    // performing click operation if element is displayed
		if (isDisplayed == true) {
        checkBoxDisplayed.click();
    }

    /**
     * Validate isEnabled and click
     */
    WebElement checkBoxEnabled = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
    boolean isEnabled = checkBoxEnabled.isEnabled();

    // performing click operation if element is enabled
		if (isEnabled == true) {
        checkBoxEnabled.click();
    }
}

    public void submitRegistration(){
        click(By.xpath("//button[@type='submit']"));
    }

    public void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }

   public void logout(){
        click(By.xpath("//*[.=' Logout ']"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[.=' Logout ']"));
    }
    public void clickOK(){
        click(By.xpath("//*[@class='positive-button ng-star-inserted']"));
    }

}
