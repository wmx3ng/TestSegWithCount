package cn.com.test.wong.token;

import cn.com.test.wong.token.analysis.StatHotWords;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String testStr = "中华人民共和国中华人民共和国中华人民共和国";
        StatHotWords statHotWords = new StatHotWords();
      List<String> hotWords=  statHotWords.getHotWords(testStr,2);
        for (String hotWord : hotWords) {
            System.out.println(hotWord);
        }
//        System.out.println(statHotWords.segImpl(testStr,3).toString());
    }
}
