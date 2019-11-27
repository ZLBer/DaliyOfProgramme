package leetcode.leetcode1_499;



import java.util.HashMap;
import java.util.Map;

public class leet290 {
/*    public boolean wordPattern(String pattern, String str) {
        Map<String,String> map=new HashMap<>();
        String []strings=str.split(" ");
        for (int i = 0; i < strings.length; i++) {
            char key=pattern.charAt(i);
            if(map.containsKey(key+"")&&!map.get(key).equals(strings[i])){
                    return false;
            }
           else if(map.containsKey(strings[i])&&!map.get(strings[i]).equals(key+"")){
               return false;
            }
            else {
                map.put(key+"",strings[i]);
                map.put(strings[i],key+"");
            }
        }
        return true;
    }*/

// 理解错意思了
  /*  public boolean wordPattern(String pattern, String str) {
        int []letter=new int[26];
        for(int i=0;i<pattern.length();i++){
            letter[pattern.charAt(i)-'a']++;
        }

        Map<String,Integer> map=new HashMap<>();
         for(String s:str.split(" ")){
            int value= map.getOrDefault(s,0)+1;
             map.put(s,value);
         }

         for(int val:map.values()){
             boolean flag=false;
             for (int i = 0; i < letter.length; i++) {
                  if(val==letter[i]) {
                      letter[i]=0;
                      flag=true;
                      break;
                  }
             }
             if(!flag)return false;
         }
         return true;
    }*/

/*    static  public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map=new HashMap<>();
        String []strings=str.split(" ");
        if(pattern.length()!=strings.length) return false;
        for (int i = 0; i < strings.length; i++) {
            char key=pattern.charAt(i);
            if(map.containsKey(key)){

               if(!map.get(key).equals(strings[i]))
                return false;
               else continue;
            }
           else {
               if(map.containsValue(strings[i])) return false;
               else map.put(key,strings[i]);
            }
        }
        return true;
    }*/


//看最近的index相等吗
  static public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i){
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;

        }
        return true;
    }


    public static void main(String[] args) {
   wordPattern("abba","dog cat cat do");
    }

}
