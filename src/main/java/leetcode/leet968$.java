package leetcode;

import java.util.HashMap;
import java.util.Map;
public class leet968$ {
/*
 static   public int minCameraCover(TreeNode root) {
    if(root.left==null&&root.right==null) return 1;
   int res=  dfs(root.left,false,true);

        System.out.println(yes.get(root)+"  "+no.get(root));
        return res;
    }
   static Map<TreeNode,Integer> yes=new HashMap<>();
  static   Map<TreeNode,Integer> no=new HashMap<>();
 static    Integer dfs(TreeNode node,boolean parentIsPic,boolean isRoot){
      if(node==null) return 0;
     Integer res=10001;
    if(isRoot||parentIsPic){ //父节点被监控
          int y=1001,n=1001;
          if(yes.containsKey(node)){
              y=yes.get(node);
          }else {
              y=dfs(node.left,true,false)+dfs(node.right,true,false)+1;
          }


          if(no.containsKey(node)){
              n=no.get(node);
          }else {
              n=dfs(node.left,false,false)+dfs(node.right,false,false);
          }

         if(y<n){
             res=y;
             yes.put(node,res);

         }else {
             res=n;
             no.put(node,res);


         }

      }
      else {
          //父节点未被监控 ,该节点必须监
        //这块想的不对  左右子树只要有一个添加监控就ok
             if(yes.containsKey(node)) return yes.get(node);
         res= dfs(node.left,true,false)+dfs(node.right,true,false)+1;
             yes.put(node,res);

     }
   return res;
    }

    */





    //本质上是贪心，能不加就不加。加载根节点比叶子节点要好

/*    //NO_CAMERA表示的是子节点没有相机，当前节点也没放相机
    private final int NO_CAMERA = 0;
    //HAS_CAMERA表示当前节点有一个相机
    private final int HAS_CAMERA = 1;
    //NO_NEEDED表示当前节点没有相机，但他的子节点有一个相机，把它给
    //覆盖了，所以它不需要了。或者他是一个空的节点也是不需要相机的
    private final int NO_NEEDED = 2;

    //全局的，统计有多少相机
    int res = 0;
    private boolean t;

    public int minCameraCover(TreeNode root) {
        //边界条件判断
        if (root == null)
            return 0;
        //如果最后返回的是NO_CAMERA，表示root节点的子节点也没有相机，
        //所以root节点要添加一个相机
        if (dfs(root) == NO_CAMERA)
            res++;
        //返回结果
        return res;
    }

    public int dfs(TreeNode root) {
        //如果是空的，就不需要相机了
        if (root == null)
            return NO_NEEDED;
        int left = dfs(root.left), right = dfs(root.right);
        //如果左右子节点有一个是NO_CAMERA，表示的是子节点既没相机，也没相机覆盖它，
        //所以当前节点需要有一个相机
        if (left == NO_CAMERA || right == NO_CAMERA) {
            //在当前节点放一个相机，统计相机的个数
            res++;
            return HAS_CAMERA;
        }
        //如果左右子节点只要有一个有相机，那么当前节点就不需要相机了，否则返回一个没有相机的标记
        return left == HAS_CAMERA || right == HAS_CAMERA ? NO_NEEDED : NO_CAMERA;
    }*/




     // 自己看题解 重写了一下  超时了
    //但可以加个memo记录下当前的状态就好了
    public int minCameraCover(TreeNode root) {
     return Math.min(help(root,true, false),help(root,false,false));
    }


    Map<String,Integer> map=new HashMap<>();
   int help(TreeNode root,boolean isPlace,boolean watched){
        if(root==null) {
            if (isPlace) {    // 父节点问自己有相机的情况，但臣妾办不到
                return 10001; // 返回一个无穷大，让这个返回值失效
            } else {
                return 0;
            }
        }


        String key=root.toString()+"-"+(isPlace?1:0)+(watched?1:0);
        if(map.containsKey(key)) return map.get(key);
    //已放置
     int res=0;
      if(isPlace){
       res= 1+ Math.min(
   Math.min(help(root.left,true,true)+help(root.right,false,true),
           help(root.left,false,true)+help(root.right,true,true)),
    Math.min( help(root.left,false,true)+help(root.right,false,true),
            help(root.left,true,true)+help(root.right,true,true))
       );
     //未放置  但可监控到
      }else if(watched){
    res= Math.min(
            Math.min(help(root.left,true,false)+help(root.right,false,false),
                    help(root.left,false,false)+help(root.right,true,false)),
            Math.min( help(root.left,false,false)+help(root.right,false,false),
                    help(root.left,true,false)+help(root.right,true,false))
    );
      }
      //既没有放置 也不能被监控到
      else {
          res= Math.min(
     Math.min( help(root.left,true,false)+help(root.right,false,false),
             help(root.left,false,false)+help(root.right, true,false)),
        help(root.left,true,false)+help(root.right,true,false)
     );
      }

     map.put(key,res);
     return res;
   }

    public static void main(String[] args) {
  TreeNode root=new TreeNode(0);
  TreeNode r1=new TreeNode(1);
  root.left=r1;
//  TreeNode le=new TreeNode(2);
//  TreeNode ri=new TreeNode(3);
//    r1.left=le;
//    r1.right=ri;
    //minCameraCover(root);
     }
}
