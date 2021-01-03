package leetcode;

public class leet1668 {
    public int maxRepeating(String sequence, String word) {
        int res=0;
        for (int i = 0; i +word.length()<=sequence.length(); i++) {
            int k=0;
            for(int j=i;j+word.length()<=sequence.length();){
              if(word.equals(sequence.substring(j,j+word.length()))){
                  k++;
                  j+=word.length();
              }else {
                  break;
              }
            }
            res=Math.max(res,k);
        }
        return res;
    }
}
