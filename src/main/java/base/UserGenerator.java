package base;

import java.util.Random;

public class UserGenerator {

    public String getName(){
        return "Julia";
    }
    public String getRandomEmail() {
        String symbols = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        while (stringBuilder.length() < 10) {
            int index = (int) (random.nextFloat() * symbols.length());
            stringBuilder.append(symbols.charAt(index));
        }
        String email = stringBuilder.toString();
        return email+"@mail.ru";
    }

    public String getPassword() {
        return "1q2w3e4r5t";
    }

    public String getShortPassword() {
        return "1q2w";
    }

}
