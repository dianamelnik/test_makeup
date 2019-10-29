import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GenerateLogin {
    public static List<String> generateLogin(WebDriver driver) throws InterruptedException {
        driver.get("https://temp-mail.org/ru/");

        List<String> list = new ArrayList<>();

        for (int i = 0; i <10; i++) {
            TimeUnit.SECONDS.sleep(7);
            String mail = driver.findElement(By.xpath("//input[@id='mail']")).getAttribute("value");
            System.out.println("Mail created :"+mail);
            driver.findElement(By.xpath("//button[@id='click-to-delete']")).click();
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(By.xpath("//a[@id='click-to-refresh']")).click();

            list.add(mail);
        }
        return list;
    }
}
