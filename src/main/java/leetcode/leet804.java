package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by libin on 2019/1/6.
 */
public class leet804 {
    public int uniqueMorseRepresentations(String[] words) {
 String []table={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> result = new HashSet();
      for(String  word :words){
          StringBuilder code=new StringBuilder();
          for(char a:word.toCharArray()){
              code.append(table[a-'a']);
          }
          result.add(code.toString());

      }
      return result.size();
    }
}
