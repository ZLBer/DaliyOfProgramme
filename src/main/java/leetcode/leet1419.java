package leetcode;

public class leet1419 {

    //mine
    public int minNumberOfFrogs(String croakOfFrogs) {


     //  Map<Character,Integer> map=new HashMap<>();
       int []map=new int[5];
      /* map.put('c',0);
        map.put('r',0);
        map.put('o',0);
        map.put('a',0);
        map.put('k',0);*/
        int count=0;
        int res=0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
           char c=croakOfFrogs.charAt(i);

           switch (c){
               case 'c':{
                   map[0]++;
                   count++;
                   break;
               }
               case 'r':{
                   if(map[0]<1) return -1;
                   map[0]--;
                   map[1]++;
                   break;
               }
               case 'o':{
                   if(map[1]<1) return -1;
                   map[1]--;
                   map[2]++;
                   break;
               }
               case 'a':{
                  if(map[2]<1) return -1;
                   map[2]--;
                   map[3]++;
                   break;
               }
               case 'k':{
                   if(map[3]<1) return -1;
                   map[3]--;
                   map[4]++;
                   count--;
                   break;
               }
           }
           res=Math.max(count,res);

        }

        for (int i = 0; i < map.length-1; i++) {
            if(map[i]!=0) return -1;
        }
        return res;
    }

    //完全可以不用数组
    /*public int minNumberOfFrogs(String croakOfFrogs) {
        int max = 0;
        int c = 0, r = 0, o = 0, a = 0;
        int frogs = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            switch (ch) {
                case 'c':
                    c++;
                    frogs++;
                    max = Math.max(max, frogs);
                    break;
                case 'r':
                    if (c == 0) return -1;
                    c--;
                    r++;
                    break;
                case 'o':
                    if (r == 0) return -1;
                    r--;
                    o++;
                    break;
                case 'a':
                    if (o == 0) return -1;
                    o--;
                    a++;
                    break;
                case 'k':
                    if (a == 0) return -1;
                    a--;
                    frogs--;
                    break;
            }
        }

        return frogs == 0 ? max : -1;
    }
*/
  //简化版本
/*    public int minNumberOfFrogs(String croakOfFrogs) {
        int cnt[] = new int[5];
        int frogs = 0, max_frogs = 0;
        for (var i = 0; i < croakOfFrogs.length(); ++i) {
            var ch = croakOfFrogs.charAt(i);
            var n = "croak".indexOf(ch);
            ++cnt[n];
            if (n == 0)
                max_frogs = Math.max(max_frogs, ++frogs);
            else if (--cnt[n - 1] < 0)
                return -1;
            else if (n == 4)
                --frogs;
        }
        return frogs == 0 ? max_frogs : -1;
    }*/
}
