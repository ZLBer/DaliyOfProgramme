package leetcode.leetcode500_999;

import java.util.LinkedList;
import java.util.Queue;

public class leet649  {
    //mine 错误的方法 虽然能通过很多用例
 /*   public String predictPartyVictory(String senate) {
       boolean[]dead=new boolean[senate.length()];
       int countR=0,countD=0;
        Queue<Integer> liveR=new LinkedList<>();
        Queue<Integer> liveD=new LinkedList<>();
        while (true) {
            for (int i = 0; i < senate.length(); i++) {
                if (dead[i]) continue;
                char c = senate.charAt(i);
                if (c == 'R') {
                    //能否被杀死
                    if (countD > 0) {
                        countD--;
                        dead[i] = true;
                    }
                    //能否去杀一个人
                    else if (!liveD.isEmpty()) {
                        dead[liveD.poll()] = true;
                        liveR.offer(i);
                    }
                     //攒一波能量
                    else {
                        countR++;
                        liveR.offer(i);
                    }
                } else {
                    if (countR > 0) {
                        countR--;
                        dead[i] = true;
                    }else if(!liveR.isEmpty()){
                       dead[liveR.poll()]=true;
                       liveD.offer(i);
                    }
                    else {
                        countD++;
                        liveD.offer(i);
                    }
                }
            }
            for (int i = 0; i < dead.length; i++) {
                System.out.print(dead[i]);
            }
            System.out.println();
            if(liveD.isEmpty()) return "Radiant";
            if(liveR.isEmpty()) return "Dire";
        }
    }*/

  //mine 修改版  要明白一个原则  优先杀死后面的
 /*   public String predictPartyVictory(String senate) {
        boolean[]dead=new boolean[senate.length()];
        int countR=0,countD=0;
        Queue<Integer> liveR=new LinkedList<>();
        Queue<Integer> liveD=new LinkedList<>();
        while (true) {
            for (int i = 0; i < senate.length(); i++) {
                if (dead[i]) continue;
                char c = senate.charAt(i);
                if (c == 'R') {
                    //能否被杀死
                    if (countD > 0) {
                        countD--;
                        dead[i] = true;
                    }
                    //攒一波能量
                    else {
                        countR++;
                        liveR.offer(i);
                    }
                } else {
                    if (countR > 0) {
                        countR--;
                        dead[i] = true;
                    }
                    else {
                        countD++;
                        liveD.offer(i);
                    }
                }
            }

            //开始处理之前存下票数  以下两种情况只能执行一个
            while (countD-->0&&!liveR.isEmpty()){
                dead[liveR.poll()]=true;
            }
            while (countR-->0&&!liveD.isEmpty()){
                dead[liveD.poll()]=true;
            }
            //若有一队列为空 则证明全部被杀死了
            if(liveD.isEmpty()) return "Radiant";
            if(liveR.isEmpty()) return "Dire";
            //重置状态
             liveD.clear();
            liveR.clear();countD=0;countR=0;
        }
    }*/

  //看看人家的多么简洁
    //核心就是必须要杀死最近的下一个对手
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<Integer>(), q2 = new LinkedList<Integer>();
        int n = senate.length();
        for(int i = 0; i<n; i++){
            if(senate.charAt(i) == 'R')q1.add(i);
            else q2.add(i);
        }
        while(!q1.isEmpty() && !q2.isEmpty()){
            int r_index = q1.poll(), d_index = q2.poll();
            if(r_index < d_index)q1.add(r_index + n); //其实就是进入下一轮的意思
            else q2.add(d_index + n);
        }
        return (q1.size() > q2.size())? "Radiant" : "Dire";
    }
}
