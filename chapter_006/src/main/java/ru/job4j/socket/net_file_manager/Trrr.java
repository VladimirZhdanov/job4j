package ru.job4j.socket.net_file_manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trrr {
    public static void main(String[] args) {
        String text = "grEFrg45534";
        Pattern pattern = Pattern.compile("[a-zA-Z]*\\s{0}\\d*");
        boolean f = Pattern.matches("[a-zA-Z]*\\s{0}\\d*", text);
        System.out.println(f);
        //Matcher matcher = pattern.matcher(text);
        //matcher.find();
        //System.out.println(text.substring(matcher.start(), matcher.end()));
        //while (matcher.find()) {
         //   System.out.println(text.substring(matcher.start(), matcher.end()));
       // }
    }
}
