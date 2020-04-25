package leetcode;

public class leet1415 {


    //mine dfs
/*    char[]set=new char[]{'a','b','c'};
    public String getHappyString(int n, int k) {
        res="";
    helper("",1,'1',n,k);
    return res;
    }

    String res="";
    int count=0;
    void helper(String s,int deep,char pre,int n,int k){

        if(deep==n+1){
            count++;
            if(count==k) {
                res=s;
            }
            return;
        }


        for (int i = 0; i < set.length; i++) {
            if(set[i]!=pre){
                helper(s+set[i],deep+1,set[i],n,k);
            }
        }
    }*/

  //数学思维
    public String getHappyString(int n, int k) {
         int prem=1<<(n-1);
         if(k>3*prem) return "";

         String s=""+(char)('a'+(k-1)/prem);//第一位已经填好了
         while (prem>1){
             k-=prem*((k-1)/prem); //更新k
             prem>>>=1; //更新prem

             if((k-1)/prem==0){  //表示顺位第一个
                 if(s.charAt(s.length()-1)=='a') s+='b';
                 else s+='a';
             }else {//表示顺位第二个
                if(s.charAt(s.length()-1)!='c'){
                    s+='c';
                }else {
                    s+='b';
                }
             }
             s+= ((k-1)/prem==0?(char)('a'+s.charAt(s.length()-1)=='a'?1:0):(char)('b'+s.charAt(s.length()-1)!='c'?1:0));
         }
         return s;
    }


 //先找出第一个排列   然后依次进位
    /*public String getHappyString(int n, int k) {
        HappyString hs = new HappyString(n);
        for (int i = 1; i < k && hs.valid; i++) {
            hs.increase();
        }
        return hs.toString();
    }

    private class HappyString {
        private final char[] chars;
        public boolean valid;
        public HappyString(int length) {
            chars = new char[length];
            for (int i = 0; i < length; i++) {
                chars[i] = i % 2 == 0 ? 'a' : 'b';
            }
            valid = true;
        }

        public void increase() {
            int i = chars.length - 1;
            boolean updated = false;
            while (i > 0 && !updated) {
                if (chars[i] == 'c' || (chars[i] == 'b' && chars[i - 1] == 'c')) {
                    i--;
                } else if (chars[i - 1] - chars[i] == 1) {
                    chars[i] += 2;
                    updated = true;
                } else {
                    chars[i]++;
                    updated = true;
                }
            }
            if (!updated && i == 0) {
                chars[i]++;
                valid = chars[i] != 'd';
            }
            if (valid) {
                for (int j = i + 1; j < chars.length; j++) {
                    chars[j] = ((j - i) % 2 == 0 ^ (chars[i] == 'a')) ? 'b' : 'a';
                }
            }
        }

        @Override
        public String toString() {
            if (!valid) {
                return "";
            }
            StringBuilder result = new StringBuilder(chars.length);
            for (char c : chars) {
                result.append(c);
            }
            return result.toString();
        }
    }*/

}
