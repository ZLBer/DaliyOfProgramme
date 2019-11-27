package leetcode.leetcode500_999;

public class leet838 {
   static public String pushDominoes(String dominoes) {
        dominoes="L"+dominoes+"R";
        char []domainoe=dominoes.toCharArray();
        char[]result=dominoes.toCharArray();
        int index=0;
        while (index<domainoe.length-1){
            int left=index;
            int right=0;
            for (int j=index+1;j<dominoes.length();j++){
                if(domainoe[j]!='.') {
                    right = j;
                    break;
                }
            }
           if(domainoe[left]=='L'&&domainoe[right]=='L'){
               while (left<right){
                   result[left++]='L';
               }
           }else if(domainoe[left]=='R'&&domainoe[right]=='R') {
               while (left < right) {
                   result[left++] = 'R';
               }
           }
           else if(domainoe[left]=='R'&&domainoe[right]=='L'){
               int temr=right;
               while (left<temr){
                   result[left++]='R';
                   result[temr--]='L';
               }
           }
           index=right;
        }

        StringBuilder sb=new StringBuilder();
       for (int i = 1; i < result.length-1; i++) {
            sb.append(result[i]);
       }
       return sb.toString();
    }




    //相比上面难理解一点
    /*public String pushDominoes(String dominoes) {
        char[] a = dominoes.toCharArray();
        int L = -1, R = -1;//上一次 L R出现的位置 每次拿这次的和上次的相比
        for (int i = 0; i <= dominoes.length(); i++)
            if (i == a.length || a[i] == 'R') {
                if (R > L)//R..R, turn all to R
                    while (R < i)
                        a[R++] = 'R';
                R = i;
            } else if (a[i] == 'L')
                if (L > R || (R == -1 && L == -1))//L..L, turn all to L
                    while (++L < i)
                        a[L] = 'L';
                else { //R...L
                    L = i;
                    int lo = R + 1, hi = L - 1;
                    while (lo < hi) { //one in the middle stays '.'
                        a[lo++] = 'R';
                        a[hi--] = 'L';
                    }
                }
        return new String(a);
    }*/
    public static void main(String[] args) {
        pushDominoes(".L.R...LR..L..");
    }
}
