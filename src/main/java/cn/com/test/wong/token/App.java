package cn.com.test.wong.token;

import cn.com.test.wong.token.analysis.StatHotWordsSegment;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String testStr = "家住大砂坪五一馨苑小区的王先生昨日向记者投诉称，去年3月份他家装修房子，6月份完工，当时装修工从黄河北的富星家居购买了一组暖气片，11月20日暖气片出现裂缝后把他家木地板和壁纸泡坏了，造成4000多元的损失，他多次找装修工和商家，欲协商解决，但时至今日仍然无果。\\n  \\n 　　王先生昨日告诉记者，他是去年3月份找的个体装修工开始装修房子的，当时装修工从黄河北的富星家居广场内的一商户处购买了一组暖气片装在家里，房子装修完工是去年6月份，供暖前进行试压时并没有问题。但去年11月20日，家里的暖气片出现裂缝把他家的木地板和壁纸都泡坏了，造成4000多元的损失。“装修工当时购买暖气片时并没有从暖气片销售商处索要发票或任何凭证。”王先生说，当时装修工就和暖气片销售商进行了电话联系，可商家并没有给出任何解决办法。\\n  \\n 　　就王先生遇到的这一问题，业内人士表示，市场上所售的暖气片分为多种材质。其中，最常见的是铸铁暖气片，其使用寿命较长，可达到50年。相比之下，钢质暖气片虽然外表更光滑，但由于北方水质特性，容易出现氧化腐蚀漏水问题。\\n  \\n 　　兰州（楼盘）市城关区消协秘书长刘振源在听取了记者讲述王先生遇到的这一问题后表示，像王先生遇到的这一问题，社会上是大量存在的，许多市民图便宜，装修时找“散兵游勇”的装修工，遇到问题后消协也不好协调，因为这些装修工并没有实体公司，而且消费者和装修工之间也并未签订合同。“消协协调也只能是按照书面合同进行协调，王先生遇到的这种情况比较麻烦，建议王先生寻找律师，通过起诉这一法律途径进行维权”。\\n  \\n 　　刘振源秘书长通过本报提醒市民：市民在装修房屋时，一定要找国家认可、有资质的正规装修公司，并签订书面合同，约定双方的权责。";
        StatHotWordsSegment statHotWords = new StatHotWordsSegment();
        List<String> hotWords = statHotWords.getHotWords(testStr, 3);
        for (String hotWord : hotWords) {
            System.out.println(hotWord);
        }
    }
}
