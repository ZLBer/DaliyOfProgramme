package leetcode.leetcode1000_;

public class leet1370 {
    //mine 统计频率
    public String sortString(String s) {
   int[]count=new int[26];
   for(char c:s.toCharArray()){
       count[c-'a']++;
   }
//是否修改标记
boolean flag=false;
   StringBuilder res=new StringBuilder();
   int temp=0;
    while (temp<s.length()) {
 //从小到大
    for (int i = 0; i < count.length; i++) {
       if(count[i]-->0) {
           res.append((char)('a'+i));
           temp++;
       }
    }

        for (int i = count.length - 1; i >= 0; i--) {
            if(count[i]-->0){
                res.append((char)('a'+i));
                 temp++;
            }
        }

}
return res.toString();
    }




    //treeMap
/*    public String sortString(String s) {
        StringBuilder ans = new StringBuilder();
        TreeMap<Character, Integer> tm = new TreeMap<>();
        for (char c : s.toCharArray()) {
            tm.put(c, 1 + tm.getOrDefault(c, 0));
        }
        boolean asc = true;
        while (!tm.isEmpty()) {
            for (char c : asc ? new TreeSet<>(tm.keySet()) : new TreeSet<>(tm.descendingKeySet())) {
                ans.append(c);
                tm.put(c, tm.get(c) - 1);
                tm.remove(c, 0);
            }
            asc = !asc; // same as asc ^= true;
        }
        return ans.toString();
    }*/
}
