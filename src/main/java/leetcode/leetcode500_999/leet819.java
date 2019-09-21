package leetcode.leetcode500_999;

import java.util.*;

/**
 * Created by libin on 2019/1/8.
 */
public class leet819 {

 static    public String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        //     \W 匹配非字母、数字、下划线。等价于 '[^A-Za-z0-9_]'。
        //\s	匹配任何空白字符，包括空格、制表符、换页符等等。等价于 [ \f\n\r\t\v]。
//     System.out.println(p.replaceAll("\\W+" , " "));
        String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

//    public String mostCommonWord(String paragraph, String[] banned) {
//        paragraph += ".";
//
//        Set<String> banset = new HashSet();
//        for (String word: banned) banset.add(word);
//        Map<String, Integer> count = new HashMap();
//
//        String ans = "";
//        int ansfreq = 0;
//
//        StringBuilder word = new StringBuilder();
//        for (char c: paragraph.toCharArray()) {
//            if (Character.isLetter(c)) {
//                word.append(Character.toLowerCase(c));
//            } else if (word.length() > 0) {
//                String finalword = word.toString();
//                if (!banset.contains(finalword)) {
//                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
//                    if (count.get(finalword) > ansfreq) {
//                        ans = finalword;
//                        ansfreq = count.get(finalword);
//                    }
//                }
//                word = new StringBuilder();
//            }
//        }
//
//        return ans;
//    }
public static void main(String[] args) {
    System.out.println(mostCommonWord("Bob ,.hit a ball, the hit BALL flew far after it was hit.",new String[]{"bob"}));
}
}
