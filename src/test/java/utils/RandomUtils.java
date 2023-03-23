package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[]args) {
        System.out.println(getRandomstring(10));
        System.out.println(getRandomInt(10, 100));
        System.out.println(getRandoEmail());

        String[] names = {"a", "b", "c" , "d" , "e"};
        System.out.println(getRandomItemFromArray(names));
    }

    private static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


    public static String getRandomstring(int length) {
        String AB ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public static String getRandoEmail() {
        return getRandomstring(10) + "@qa.guru";
    }
    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

}
