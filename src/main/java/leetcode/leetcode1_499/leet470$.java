package leetcode.leetcode1_499;

public class leet470$ {
    //可以继续推广 https://leetcode.com/problems/implement-rand10-using-rand7/discuss/150301/Three-line-Java-solution-the-idea-can-be-generalized-to-%22Implement-RandM()-Using-RandN()%22
    class Solution  {
        public int rand10() {
            int result = 40;
            while (result >= 40) {result = 7 * (rand7() - 1) + (rand7() - 1);}
            return result % 10 + 1;
        }

        public int rand7(){
            return 0;
        }
    }
}
