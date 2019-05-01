package leetcode;

public class leet748 {
    //mine 数组存储
   /* public String shortestCompletingWord(String licensePlate, String[] words) {
        int [] letter=new int[26];
        int letterCount=0;
        int minLength=Integer.MAX_VALUE;
        for (char c:licensePlate.toLowerCase().toCharArray()){
            if(c>='a'&&c<='z'){
                letter[c-'a']++;
                letterCount++;
            }

        }
        String result="";
        for (String s:words){
            int count=0;
            int []temp=letter.clone();
            for(char c:s.toCharArray()){
                  if(temp[c-'a']>0){
                      temp[c-'a']--;
                      count++;
                  }
            }
            if(count==letterCount){
               if(s.length()<minLength){
                   result=s;
                   minLength=s.length();
               }

            }
        }
        return result;
    }
*/

  // 质数乘法   nice啊！！
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

    public String shortestCompletingWord(String licensePlate, String[] words) {
        long charProduct = getCharProduct(licensePlate.toLowerCase());
        String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
        for(String word : words)
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                shortest = word;
        return shortest;
    }

    private long getCharProduct(String plate) {
        long product = 1L;
        for(char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25)
                product *= primes[index];
        }
        return product;
    }
}
