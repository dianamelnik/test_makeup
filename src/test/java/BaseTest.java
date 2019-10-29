import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        versionOfOS();


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void versionOfOS() {
        String s = System.getProperty("os.name");
        if (s.contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_linux64");

        } else if (s.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_win32");
        } else if (s.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_mac77");
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
