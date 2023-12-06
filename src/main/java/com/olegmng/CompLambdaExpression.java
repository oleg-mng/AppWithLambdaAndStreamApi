package com.olegmng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompLambdaExpression {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "c#", "c++", "python", "kotlin", "perl", "pascal");
        System.out.println(list);

//        list.sort(new StringLengthComparator());
//        System.out.println(list);

        //use anonymous class
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) return -1;
                else if (o1.length() > o2.length()) return 1;
                return 0;
            }
        });
        System.out.println(list);

        Comparator<String> stringComparator = (o1, o2) -> o1.length()-o2.length();
        //inline
        list.sort((o1, o2) -> o1.length()-o2.length());
        System.out.println(list);

    }
//    static class StringLengthComparator implements Comparator<String>{
//
//        @Override
//        public int compare(String o1, String o2) {
//            if (o1.length() < o2.length()) return -1;
//            if (o1.length() > o2.length()) return 1;
//            return 0;
//        }
//    }



}
