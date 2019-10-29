import model.MakeUpCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestSuccess {

    public static boolean testSuccess(WebDriver driver, MakeUpCredentials generateCredential) {
        try {

            driver.get("https://makeup.com.ua/");

            WebElement buttonCabinet = driver.findElement(By.xpath("//div[@data-popup-handler='auth']"));
            buttonCabinet.click();

            WebElement buttonRegistration = driver.findElement(By.xpath("//a[@href='/register/']"));
            buttonRegistration.click();

            WebElement fieldName = driver.findElement(By.xpath("//input[@id='name']"));
            fieldName.sendKeys("Name");

            WebElement fieldLastName = driver.findElement(By.xpath("//input[@id='surname']"));
            fieldLastName.sendKeys("LastName");

            WebElement fieldEmail = driver.findElement(By.xpath("//input[@id='email']"));
            fieldEmail.sendKeys(generateCredential.getLogin());

            WebElement fieldPhone = driver.findElement(By.xpath("//input[@id='phone']"));
            fieldPhone.click();
            fieldPhone.sendKeys(
                generateCredential
                    .getPhoneNumber());
            Thread.sleep(1000);

            WebElement fieldCity = driver.findElement(By.xpath("//input[@id='city']"));
            fieldCity.sendKeys("Киев");

            WebElement fieldCitySpecifically = driver.findElement(By.xpath("//li[@class='search-value__list_item']"));
            fieldCitySpecifically.click();

            WebElement fieldStreet = driver.findElement(By.xpath("//input[@id='street']"));
            fieldStreet.sendKeys("Киевская");

            WebElement fieldStreetSpecifically = driver.findElement(By.xpath("//li[@class='search-value__list_item']"));
            fieldStreetSpecifically.click();

            WebElement fieldHouse = driver.findElement(By.xpath("//input[@id='house']"));
            fieldHouse.sendKeys("1");

            WebElement fieldPassword = driver.findElement(By.xpath("//input[@id='password']"));

            String password = generateCredential.getPassword();

            fieldPassword.sendKeys(password);

            WebElement fieldRepeatPassword = driver.findElement(By.xpath("//input[@id='repeat-password']"));
            fieldRepeatPassword.sendKeys(password);

            WebElement buttonSubmit = driver.findElement(By.xpath("//button[@class='button']"));
            buttonSubmit.click();

            WebElement fieldCabinet = driver.findElement(By.xpath("//a[@href='/user/']"));
            fieldCabinet.click();

            WebElement fieldlogout = driver.findElement(By.xpath("//a[@href='/user/logout/']"));
            fieldlogout.click();

            return true;
        } catch (Exception ex) {
            return false;
        }
    }


}

