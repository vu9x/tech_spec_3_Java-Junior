package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


//        final String text = "Julia Evans was @born on 25-09-1984. "
//                + "She is currently living in the USA (United States of America).";
//
//        final String regex = "@[A-z]*";
//        final String string1 = "@Julia Evans was born on 25-09-1984.";
//
//        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
//        final Matcher matcher = pattern.matcher(text);
//        System.out.println(matcher.matches());


        String regex = "@[A-z]*";
        String string = "Julia @Evans @was @born on 25-09-1984.";

        Pattern pattern = Pattern.compile("@[A-z]*");
        Matcher matcher = pattern.matcher(string);
        matcher.find();
        String name = matcher.group(0);
        System.out.println(name);

        StringBuilder sb = new StringBuilder(matcher.group(0));
        sb.deleteCharAt(0);

        System.out.println(sb.toString());

//        while (matcher.find()) {
//            System.out.println("Full match: " + matcher.group(0));
//
//            for (int i = 1; i <= matcher.groupCount(); i++) {
//                System.out.println("Group " + i + ": " + matcher.group(i));
//            }
//        }

    }
}