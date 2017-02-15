package cn.com.test.wong.token;

import cn.com.test.wong.token.analysis.StatHotWords;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String testStr = "中华人民的  共和国    啊!";
        StatHotWords statHotWords = new StatHotWords();
        System.out.println(statHotWords.segImpl(testStr).toString());
    }
}
