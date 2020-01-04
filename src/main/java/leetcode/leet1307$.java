package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1307$ {

    //要是以单词长度做dfs怎么遍历呢
/*  public boolean isSolvable(String[] words, String result) {
        Map<Character,Integer> map=new HashMap<>();


    }

    boolean DFS(String[] words,String result,int deep,int jinW, Map<Character,Integer> map){
       if(deep>result.length()) return false;

       int index=result.length()-deep-1;

       int sum=jinW;
        for (int i = 0; i < words.length; i++) {
            char c=words[i].charAt(index);
            if(map.containsKey(c)) sum+=map.get(c);
            for(int num=0;num<=9;num++){

             }
        }
    }*/


//mine   别想了  肯定TLE  以words列表作为dfs的深度
/*    public boolean isSolvable(String[] words, String result) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for(char c:words[i].toCharArray()){
                map.put(c,0);
            }
        }
        for(char c:result.toCharArray()){
            map.put(c,0);
        }
       return dfs(map,words,result,0,new boolean[10]);

    }
    boolean dfs(Map<Character,Integer> map, String[]words,String result,int count,boolean []visited){
        if(count==map.size()){
          return  check(words,result,map);
        }

        for(int num=0;num<10;num++){
            if(visited[num]) continue;
           int n=0;
            for(char key:map.keySet()){
              if(n==count){
                  map.put(key,num);

                  break;
              }
              n++;
           }
            visited[num]=true;
           if( dfs(map,words,result,count+1,visited)) return true;
           visited[num]=false;
        }
        return false;
    }

    boolean check(String[]words,String result,Map<Character,Integer> map){

        int preSum=0;
        for(int i=0;i<result.length();i++){
            int taget=map.get(result.charAt(result.length()-i-1));
            int sum=preSum;
            for(int j=0;j<words.length;j++){
              if(words[j].length()-i-1>=0)
                sum+=map.get(words[j].charAt(words[j].length()-i-1));
            }
             if(sum%10==taget) {
                preSum=sum/10;
                 continue;
             }
             else return false;
        }
        return true;
    }*/


//做题换一个思路  不按照他给的格式，而是把所有的字母都统计出来，按照字母顺序去dfs  把之前的三维(字母，数字，单词列表)转换成二维(字母和数字)
    public boolean isSolvable(String[] words, String result) {

     Set<Character> characterSet=new HashSet<>();
     Set<Character> noZero=new HashSet<>();
        int []charCount=new int[91];
        for (int i = 0; i < words.length; i++) {
            noZero.add(words[i].charAt(0));

           for(int j=words[i].length()-1;j>=0;j--){
               char c=words[i].charAt(j);
               characterSet.add(c);
               charCount[c]+=(int)Math.pow(10,words[i].length()-j);
           }
        }
noZero.add(result.charAt(0));
        for(int i=0;i<result.length();i++){
            char c=result.charAt(result.length()-i-1);
            characterSet.add(c);
            charCount[c]-=(int)Math.pow(10,i+1);
        }

   char[]chars=new char[characterSet.size()];
   int index=0;
        for (Character character : characterSet) {
            chars[index++]=character;
        }

    return dfs(noZero,chars,charCount,0,0,new boolean[10]);
    }



    boolean dfs(Set<Character> noZero,char []chars,int[]charCount,int deep,int sum,boolean[]used){
        if(deep==chars.length) return sum==0;
        for(int i=0;i<=9;i++){
            if(i==0&&noZero.contains(chars[deep]))continue;
          if(!used[i]){
              used[i]=true;
     if(dfs(noZero,chars,charCount,deep+1,sum+charCount[chars[deep]]*i,used))return true;
              used[i]=false;
          }
        }
        return false;
    }


}
