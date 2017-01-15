package com.cwind.string;

/**
 * Stay hungry, stay foolish.
 * Author: Cwind
 * Date: 2016/9/6
 * Description:
 */
public class InternStringTest {
    public static void main(String[] args) {
        String str1 = "Programming";
        String str2 = new String("Programming");
        String str3 = "Program" + "ming";
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str1.intern());
    }
}
