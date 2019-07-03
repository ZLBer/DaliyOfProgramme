package leetcode;

import java.util.LinkedList;
import java.util.List;

public class leet1104$ {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        int parent = label;
        result.addFirst(parent);

        while(parent != 1) {
            //求节点深度
            int d = (int)(Math.log(parent)/Math.log(2));
            //求剩余节点数量，因为间隔的两层的顺序是相反的
            int offset = (int)Math.pow(2, d+1) - 1 - parent;
            //求他的父节点
            parent = ((int)Math.pow(2, d) + offset) / 2;
            //添加结果
            result.addFirst(parent);
        }

        return result;
    }
}
