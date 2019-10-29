import model.MakeUpCredentials;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ResultWriter;

import java.util.ArrayList;
import java.util.List;

public class SimpleTest extends BaseTest {

    @BeforeClass
    public void generateLogins() throws InterruptedException {
        List<String> logins = GenerateLogin.generateLogin(driver);
        List<MakeUpCredentials> makeUpCredentials = MainClass.generateCredentials(logins);

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
                System.out.println("NOT Registered : " + credentials);
                badCredentials.add(credentials);
            }
        }
        ResultWriter.writeToFile("Success.txt", goodCredentials);
        ResultWriter.writeToFile("Failed.txt", badCredentials);

    }

    @Test(dataProvider = "successCredentials")
    public void happyRename(MakeUpCredentials readCredential) throws InterruptedException {

        if (Entrance.entrance(driver, readCredential)) {
            System.out.println("With positive data validation passed " + readCredential.getLogin() + "  " + readCredential.getPassword());//
        } else {
            System.out.println("Validation failed with positive data    " + readCredential.getLogin() + "  " + readCredential.getPassword());
        }


    }

        @Test(dataProvider = "unsuccessfulCredentials")
    public void sadRename(MakeUpCredentials readCredential) throws InterruptedException {
        if (Entrance.entrance(driver, readCredential)) {
            System.out.println("With negative data validation passed  " + readCredential);
        } else {
            System.out.println("Validation failed with negative data  " + readCredential);
        }

    }

    @DataProvider(name = "successCredentials")
    public static Object[] readSuccessCredentials() {
        List<MakeUpCredentials> credentials = ResultReader.readCredentials("Success.txt");
        return credentials.toArray();
    }

    @DataProvider(name = "unsuccessfulCredentials")
    public static Object[] readUnsuccessfulCredentials() {
        List<MakeUpCredentials> credentials = ResultReader.readCredentials("Failed.txt");
        return credentials.toArray();
    }

}
