package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet17 {

/*   //mine DFS
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return result;
          char[]arr= digits.toCharArray();
          DFS(0,arr,new StringBuilder());
          return result;
    }
    List<String> result=new ArrayList<>();
   void DFS(int deep,char[] arr,StringBuilder sb){
          if(deep>=arr.length) {
              result.add(sb.toString());
              return;
          }


       int num=arr[deep]-'2';

        for(int i=0;i<digits[num].length;i++){
            sb.append(digits[num][i]);
            DFS(deep+1,arr,new StringBuilder(sb));
            sb.deleteCharAt(sb.length()-1);
        }

    }
*/

    char [][]digits={
            {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };
 //mine 遍历
    public List<String> letterCombinations(String digit) {
        List<String> result=new ArrayList<>();
        if(digit.equals("")) return result;
        char[]arr= digit.toCharArray();
        for(int j=0;j<digits[arr[0]-'2'].length;j++){
                result.add(digits[arr[0]-'2'][j]+"");
            }

        for (int i = 1; i < arr.length; i++) {
            int num=arr[i]-'2';
            List<String> temp=new ArrayList<>();
           for(int j=0;j<digits[num].length;j++){
               for (String s : result) {
                    temp.add(s+digits[num][j]);
               }
           }
           result=temp;
        }
        return result;
    }


    //可以用队列
  /*  public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            //判断长度
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }*/


  //试着用流来做
/*  public List<String> letterCombinations(String digits) {
      String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      LinkedList<String> result = new LinkedList<>();

      if(digits.length() == 0 || digits == null){
          return result;
      }

      result.add("");
      for(int i = 0; i < digits.length(); i++){
          String digitLetters = mapping[digits.charAt(i) - '0'];

          LinkedList<String> temp = result
                  .stream()
                  .flatMap(str1 -> digitLetters.chars().mapToObj(j -> (char)j).map(str2 -> str1 + str2))
                  .collect(Collectors.toCollection(LinkedList::new));
          result = temp;
      }
      return result;
  }*/


//reduce流
  /*  public List<String> letterCombinations(String digits) {
        List<List<String>> input = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            if (c == '2') input.add(Arrays.asList("a", "b", "c"));
            else if (c == '3') input.add(Arrays.asList("d", "e", "f"));
            else if (c == '4') input.add(Arrays.asList("g", "h", "i"));
            else if (c == '5') input.add(Arrays.asList("j", "k", "l"));
            else if (c == '6') input.add(Arrays.asList("m", "n", "o"));
            else if (c == '7') input.add(Arrays.asList("p", "q", "r", "s"));
            else if (c == '8') input.add(Arrays.asList("t", "u", "v"));
            else if (c == '9') input.add(Arrays.asList("w", "x", "y", "z"));
        }

        return input.stream().reduce((a,b) -> multiply(a, b)).orElse(Collections.EMPTY_LIST);

    }

    public List<String> multiply(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>();
        for (String aa : a) {
            for (String bb : b) {
                result.add(aa + bb);
            }
        }
        return result;
    }*/
}
