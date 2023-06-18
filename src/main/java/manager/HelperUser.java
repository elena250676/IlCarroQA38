package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
   click(By.xpath("//input[@type='checkbox']"));
    }
    public void submitRegistration(){
        click(By.xpath("//button[@type='submit']"));
    }

    public void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }

   public void logout(){
        click(By.xpath("//*[.='logout']"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[.='logout']"));
    }
}
