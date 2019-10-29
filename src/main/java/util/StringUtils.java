package util;


import java.util.Random;

public class StringUtils {
    private static final Random RND = new Random();

    public static String createRandomPassword(int n) {
        int num_of_chars = n;
        Integer a;
        String num = "";
        for (int i = 0; i < num_of_chars; i++) {
            a = RND.nextInt(10);
            num += a;
        }

        return num;
    }

    public static String generateRandomMobilePhone() {
        return  "99" +createRandomPassword(7);
//        return  createRandomPassword(2) + "99" +createRandomPassword(5);
    }

}
