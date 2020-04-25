package leetcode.leetcode1_499;

public class leet133 {
    //mine DFS
/*    public Node cloneGraph(Node node) {

        return DFS(node);

    }

    Map<Integer, Node> map = new HashMap<>();

    Node DFS(Node node) {
        Node c = new Node();
        c.val = node.val;
        map.put(c.val, c);
        c.neighbors = new ArrayList<>();
        for (Node n : node.neighbors) {
            if (map.containsKey(n.val)) {
                c.neighbors.add(map.get(n.val));
            } else {
                c.neighbors.add(DFS(n));
            }
        }
        return c;

    }*/


    //mine BFS
/*    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();
        queue.add(node);
        Node x=new Node();
        x.val=node.val;
        map.put(node.val,x);
        while (!queue.isEmpty()) {
            // System.out.println("start");
            int size=queue.size();
            while (size-->0){
                Node nod = queue.poll();
                Node cNode = map.get(nod.val);
                //   cNode.val = nod.val;
                //  map.put(cNode.val, cNode);
                cNode.neighbors = new ArrayList<>();
                // System.out.println("size"+nod.neighbors.size());
                for (Node n : nod.neighbors) {
                    //  System.out.println(n.val);
                    Node c = new Node();
                    if (map.containsKey(n.val)) {
                        c = map.get(n.val);
                    } else {
                        c.val = n.val;
                        map.put(c.val,c);
                        queue.add(n);
                    }
                    cNode.neighbors.add(c);

                }
            }
        }
        //   System.out.println(map.get(node.val));
        return map.get(node.val);
    }*/
}