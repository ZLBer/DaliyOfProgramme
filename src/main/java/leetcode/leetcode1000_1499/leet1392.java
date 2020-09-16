package leetcode.leetcode1000_1499;

public class leet1392 {

    //哈哈 肯定tle啊 但居然过了这么多 70/72
 /*   public String longestPrefix(String s) {
    for(int i=1;i<s.length();i++){
        if(s.substring(0,s.length()-i).equals(s.substring(i))) return s.substring(i);
    }
    return "";
    }*/



    //求kmp的next数组
    public String longestPrefix(String s) {
        int[] next = getNext(s);
        int n = next[s.length()];
        return s.substring(0, n);
    }

    int[] getNext(String s) {
        int[] next = new int[s.length() + 1];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < s.length()) {
            if (j == -1 || s.charAt(j) == s.charAt(i))
                // 已有 [0, ..., j - 1] 与 [i - j, ..., i - 1] 匹配, 同时 s[j] == s[i]
                next[++i] = ++j;
                // 匹配长度增加 1, 查看下一个匹配位置
            else
                j = next[j];
            // 不匹配, 说明当前查看的前缀太长, 将 j 跳回到上一个可能的匹配位置
        }
        return next;
    }


    //默写一遍
/*    int[] getNext(String s) {
        int i=0,j=-1;
        int []next=new int[s.length()+1];
        next[0]=-1;
        while (i<s.length()){
            if(j==-1||s.charAt(i)==s.charAt(j)){
                next[++i]=next[++j];
            }else {
              j=next[j];
            }
        }
        return next;
    }*/


//字符串hash
/* class StrHash {
   private static final long P = 805306457;
    private static final long MOD = (int) (1e9 + 7);
    private long[] hash;
    private long[] power;
    private char[] arr;

    public StrHash(char[] arr) {
        this.arr = arr;
        int len = arr.length;
        hash = new long[len];
        power = new long[len];
        calcHashAndPower();
    }

    private void calcHashAndPower() {
        hash[0] = arr[0];
        power[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            hash[i] = (hash[i - 1] * P + arr[i]) % MOD;
            power[i] = (power[i - 1] * P) % MOD;
        }
    }

    private long getSubStrHash(int l, int r) {
        if (l == 0) {
            return hash[r];
        }
        //就是剪掉l之前的那一块
        return ((hash[r] - power[r - l + 1] * hash[l - 1]) % MOD + MOD) % MOD;
    }
}
    public String longestPrefix(String s) {
        char[] arr = s.toCharArray();
        StrHash strHash = new StrHash(arr);
        int len = arr.length;

        for (int i = len - 2; i >= 0; i--) {
            long prefix = strHash.getSubStrHash(0, i);
            long suffix = strHash.getSubStrHash(len - i - 1, len - 1);
            if (prefix == suffix) {
                return s.substring(0, i + 1);
            }
        }

        return "";
    }*/

//自己做一遍字符串hash
/*public String longestPrefix(String s) {
    long []hash=new long[s.length()+1];
    long []power=new long[s.length()+1];
    long base=131;
    int mod=(int)1e9+7;
    hash[0]=0;
    power[0]=1;
    for(int i=1;i<=s.length();i++){
     hash[i]=(hash[i-1]*base+(s.charAt(i-1)))%mod;
     power[i]=(power[i-1]*base)%mod;
     }

    for(int i=s.length()-1;i>=1;i--){
        long prefix=hash[i];
        long suffix=(hash[s.length()]-hash[s.length()-i]*power[i]%mod+mod)%mod;  //注意此处的+mod不能少 否则会出现负数
        if(prefix==suffix){
            return s.substring(i-1);
        }
     //   System.out.println(s.substring(i-1));
    }
    return "";
}*/
}
