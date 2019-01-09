package leetcode;

/**
 * Created by libin on 2019/1/8.
 */
public class leet925 {
    //基于分组的思想
   static public boolean isLongPressedName(String name, String typed) {
        int i=0,j=0;
        for(;i<name.length()&&j<typed.length();){
            if(name.charAt(i)!=typed.charAt(j)) return false;
            int countNameLetter=1;
            int count=1;
                while (i+1<name.length()&&(name.charAt(i)==name.charAt(i+1))) {
                    countNameLetter++;
                    i++;
                }
            while (j+1<typed.length()&&(typed.charAt(j)==typed.charAt(j+1))) {
                count++;
                j++;
            }
            System.out.println(countNameLetter+"  "+count);
            if(count<countNameLetter) return false;

            i++;
            j++;
        }
       System.out.println(i+"  "+j);
        if(i!=name.length()) return false;
           return true;
    }
          //双指针
//    public boolean isLongPressedName(String name, String typed) {
//        int i = 0, m = name.length(), n = typed.length();
//        //依次遍历typed
//        for (int j = 0; j < n; ++j)
//            //相等的话，name的指针加一
//            if (i < m && name.charAt(i) == typed.charAt(j))
//                ++i;
//        // 不相等的情况
//            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
//                return false;
//        return i == m;
//    }

    public static void main(String[] args) {
   //     System.out.println(isLongPressedName("leelee","lleeelee"));
        int a,b;
        a=b=2-1;
        System.out.println(a+ "    "+b);
    }
}
