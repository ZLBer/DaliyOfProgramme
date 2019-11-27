package leetcode.leetcode1000_;

public class leet1079$ {
    public int numTilePossibilities(String tiles) {
int []letters=new int[26];
        for(Character c:tiles.toCharArray()){
             letters[c-'a']++;
        }
        return  dfs(letters);
    }

    int dfs(int []letters){
       int sum=0;
        for (int i = 0; i < letters.length; i++) {
            if(letters[i]==0) continue;
             sum++;
             letters[i]--;
             sum+=dfs(letters);
             letters[i]++;
        }
        return sum;
    }
}
