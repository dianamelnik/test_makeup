import model.MakeUpCredentials;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultReader {

    public static List<MakeUpCredentials> readCredentials(String fileName) {
        List<MakeUpCredentials> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(" ");
                result.add(new MakeUpCredentials(s[0], s[1], s[2]));
            }
        } catch (IOException ex) {

        }
       // MakeUpCredentials makeUpCredentials = result.get(0);
       // makeUpCredentials.getPhoneNumber();
        return result;
    }
}
