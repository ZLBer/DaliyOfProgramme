package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/1/9.
 */
public class leet434 {
    //为什么这里可以通过，而leetcode不能
  static   public int countSegments(String s) {
        if(s.length()==0) return 0;
       return s.replace("\\W+"," ").split("\\s+").length;

    }
    //
//    public int countSegments(String s) {
//        return ("x " + s).split(" +").length - 1;
//    }
    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
}
