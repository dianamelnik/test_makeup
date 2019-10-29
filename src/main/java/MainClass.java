import model.MakeUpCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ResultWriter;
import util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public MainClass() {
    }

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_mac78");
        System.out.println(System.getProperty("os.name"));
        versionOfSistem();
        WebDriver driver = new ChromeDriver();

        try {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            List<String> logins = GenerateLogin.generateLogin(driver);

            List<MakeUpCredentials> makeUpCredentials = generateCredentials(logins);

            for (MakeUpCredentials generateCredential : makeUpCredentials) {
                System.out.println("Object created : " + generateCredential.toString());
            }

            List<MakeUpCredentials> goodCredentials = new ArrayList<>();
            List<MakeUpCredentials> badCredentials = new ArrayList<>();

            for (MakeUpCredentials credentials : makeUpCredentials) {
                if (TestSuccess.testSuccess(driver, credentials)) {
                    goodCredentials.add(credentials);
                    System.out.println("Registered : " + credentials);
                } else {
                    System.out.println("NOT registered : " + credentials);
                    badCredentials.add(credentials);
                }
            }
            ResultWriter.writeToFile("Success.txt", goodCredentials);
            ResultWriter.writeToFile("Failed.txt", badCredentials);

            for (MakeUpCredentials readCredential : ResultReader.readCredentials("Success.txt")) {
                if (Entrance.entrance(driver, readCredential)) {
                    System.out.println("With positive data validation passed  " + readCredential.getLogin() + "  " + readCredential.getPassword());//
                } else {
                    System.out.println("Validation failed with positive data  " + readCredential.getLogin() + "  " + readCredential.getPassword());
                }
            }

            for (MakeUpCredentials readCredential : ResultReader.readCredentials("Failed.txt")) {
                if (Entrance.entrance(driver, readCredential)) {
                    System.out.println("With negative data validation passed " + readCredential);
                } else {
                    System.out.println("Validation failed with negative data  " + readCredential);
                }
            }


        } finally {
            driver.quit();
        }


    }

    public static void versionOfSistem() {
        String s = System.getProperty("os.name");
        if (s.contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_linux64");

        } else if (s.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_win32");
        } else if (s.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_mac77");
        }
    }

    public static List<MakeUpCredentials> generateCredentials(List<String> logins) {
        List<MakeUpCredentials> result = new ArrayList<>();
        for (String login : logins) {
            result.add(
                    new MakeUpCredentials(login,
                            StringUtils.createRandomPassword(8),
                            StringUtils.generateRandomMobilePhone())
            );
        }
        return result;

    }

}




