package leetcode.leetcode1000_1499;


import java.util.ArrayList;
import java.util.List;

public class leet1472 {

    //就单纯模拟就好了 没难度
    class BrowserHistory {


        List<String> websites=new ArrayList<>();
        int current=-1;
        int end=-1;
        public BrowserHistory(String homepage) {
          websites.add(homepage);
          current=0;
          end=0;
        }

        public void visit(String url) {
           websites.add(++current,url);
           end=current;
        }

        public String back(int steps) {
          current=Math.max(0,current-steps);
          return websites.get(current);
        }

        public String forward(int steps) {
            int next=Math.min(end,current+steps);
            current=next;
            return websites.get(next);
        }
    }
}
