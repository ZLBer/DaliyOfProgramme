package leetcode.leetcode1000_1499;


import java.util.Arrays;

public class leet1366 {
 /*   public String rankTeams(String[] votes) {
        Map<Character,int[]> map=new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            String s=votes[i];
            for(int j=0;j<s.length();j++){
              char c=s.charAt(j);
              map.putIfAbsent(c,new int[votes[0].length()]);
              map.get(c)[j]++;
            }
        }
        List<Map.Entry> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,(a,b)->{
            for(int i=0;i<votes[0].length();i++){
                if(((int [])a.getValue())[i]!=((int[])b.getValue())[i]){
                    return ((int [])b.getValue())[i]-((int[])a.getValue())[i];
                }
            }
            return 0;
        });
        StringBuilder sb=new StringBuilder();
        for (Map.Entry entry : list) {
            sb.append(entry.getKey());
        }
        return sb.toString();
    }*/


    //直接用数组 这代码写的真好
    public String rankTeams(String[] votes) {
        int countTeams = votes[0].length();
        char[][] r = new char[26][countTeams + 1];

        for (char c = 0; c < 26; c += 1) {
            //全都初始化成A
            Arrays.fill(r[c], 'A');
           //为了最后的时候找出是哪一个字母  z-c是为了小的往后排
            r[c][countTeams] = (char)('Z' - c);
        }

        for (String vote : votes) {
            for (int i = 0; i < countTeams; i += 1) {
                r[vote.charAt(i) - 'A'][i] += 1;
            }
        }

        String[] s = new String[26];

        //char转String数组
        for (char c = 0; c < 26; c += 1) {
            s[c] = new String(r[c]);
        }

        //String自然排序
        Arrays.sort(s);

        StringBuilder result = new StringBuilder();

        //后面的得分高
        for (char c = 0; c < countTeams; c += 1) {
            result.append((char)('A' + 'Z' - s[25 - c].charAt(countTeams)));
        }


        return result.toString();
    }

    public static void main(String[] args) {
        String[]strings=new String[]{"AB","BA"};
        Arrays.sort(strings);
        System.out.println(strings[0]);
    }
}
