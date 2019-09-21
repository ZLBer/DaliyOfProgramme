package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/1/7.
 */
public class leet383 {
  boolean canConstruct(String ransomNote, String magazine) {
         //  char [] mag=magazine.toCharArray();
           int flag[]= new int[magazine.length()];
           int count=0;
           for(int i=0;i<ransomNote.length();i++){
               for (int j=0;j<magazine.length();j++){
                   if(ransomNote.charAt(i)==magazine.charAt(j)&&flag[j]==0){
                       flag[j]=1;
                       count++;
                       break;
                   }

               }
           }
        if(count==ransomNote.length()) return true;
        else return  false;
    }
    //先arr[26] 然后遍历magazine ++   ，然后遍历ransomNote   如果arr<0 返回false
/*    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }*/
}
