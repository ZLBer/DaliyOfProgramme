package leetcode;

/**
 * Created by libin on 2019/1/1.
 */
public class leet771 {
//  static   public int numJewelsInStones(String J, String S) {
//        int count=0;
//   for(int i=0;i<J.length();i++){
//       for (int j=0;j<S.length();j++){
//           if(J.charAt(i)==S.charAt(j)) count++;
//       }
//   }
//   return  count;
//    }
//    //添加到set里，然后遍历S 用contains判断
//    public int numJewelsInStones(String J, String S) {
//        int res = 0;
//        Set setJ = new HashSet();
//        for (char j: J.toCharArray()) setJ.add(j);
//        for (char s: S.toCharArray()) if (setJ.contains(s)) res++;
//        return res;
//    }
   // 更快的方式
  static   public int numJewelsInStones(String J, String S) {
        char[] jewels = J.toCharArray();
        int count=0;
        for(int i=0; i<jewels.length; i++)
            for(int j=0; j< S.length(); j++)
                if(S.charAt(j)== jewels[i])
                    count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA","aAAbbbb"));
    }
}
