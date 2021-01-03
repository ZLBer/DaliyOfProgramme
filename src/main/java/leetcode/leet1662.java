package leetcode;

public class leet1662 {


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    StringBuilder stringBuilder=new StringBuilder();
    StringBuilder stringBuilder1=new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            stringBuilder.append(word1[i]);
        }

        for (int i = 0; i < word2.length; i++) {
            stringBuilder1.append(word2[i]);
        }
     return  stringBuilder.toString().equals(stringBuilder1.toString());
    }



    public static void main(String[] args) {

    }
}
