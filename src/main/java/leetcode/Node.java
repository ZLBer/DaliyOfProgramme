package leetcode;

import java.util.List;

/**
 * Created by libin on 2019/1/11.
 */
public  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
