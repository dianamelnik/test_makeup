import model.MakeUpCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Entrance {

    public static boolean entrance(WebDriver driver, MakeUpCredentials readCredential) throws InterruptedException {

        try {
            driver.get("https://makeup.com.ua/");

            WebElement buttonCabinet = driver.findElement(By.xpath("//div[@data-popup-handler='auth']"));
            buttonCabinet.click();
            Thread.sleep(1000);

            WebElement fieldInputLogin = driver.findElement(By.xpath("//input[@name='user_login']"));
            fieldInputLogin.click();
            fieldInputLogin.sendKeys(readCredential.getLogin());



            WebElement fieldInputPassword = driver.findElement(By.xpath("//input[@name='user_pw']"));
            fieldInputPassword.click();
            fieldInputPassword.sendKeys(readCredential.getPassword());



            WebElement buttonSubmit = driver.findElement(By.xpath("//button[@class='button full-width']"));
            buttonSubmit.click();

            WebElement fieldCabinet = driver.findElement(By.xpath("//a[text()='Кабинет']"));
            fieldCabinet.click();

            WebElement fieldLogout= driver.findElement(By.xpath("//a[text()='Выход']"));
            fieldLogout.click();
            return true;
        } catch (Exception ex){
            return false;
        }


    }
}

