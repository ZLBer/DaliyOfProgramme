package leetcode;

import java.util.*;

public class leet1263 {
    //BFS 并不是传统的BFS 以人的状态为主
/*    public int minPushBox(char[][] grid) {
        int [][]next=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Map<Integer,Integer> dis=new HashMap<>();
        Queue<Integer>queue=new LinkedList<>();
        int []taget=new int[2],box=new int[2],player=new int[2];
        //查找相应的点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
             if(grid[i][j]=='T') taget=new int[]{i,j};
             if(grid[i][j]=='B') box=new int[]{i,j};
             if(grid[i][j]=='S') player=new int[]{i,j};
            }
        }
        int c=encode(box[0],box[1],player[0],player[1]);
       queue.offer(c);
        dis.put(c,0);
        int res=Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int code=queue.poll();
            int []state=decode(code);
            //提前剪枝
            if(dis.get(code)>res) continue;
            if(state[0]==taget[0]&&state[1]==taget[1]){
                res=Math.min(res,dis.get(code));
                continue;
            }
            int preX=state[2],preY=state[3];
            for (int i = 0; i < next.length; i++) {
                int x=preX+next[i][0],y=preY+next[i][1];
                if(x>=0&&y>=0&&x<grid.length&&y<grid[0].length){
                    //碰到砖头
                    if(grid[x][y]=='#') continue;
                    //下一个状态是箱子
                    else if(x==state[0]&&y==state[1]){
                     int tbX=state[0]+next[i][0],tbY=state[1]+next[i][1];
                        //箱子碰到蔷或出界
                     if(tbX<0||tbY<0||tbX>=grid.length||tbY>=grid[0].length||grid[tbX][tbY]=='#') continue;

                     int tc=encode(tbX,tbY,x,y);
                     //比之间的状态用的步数还长
                     if(dis.containsKey(tc)&&dis.get(tc)<=dis.get(code)+1) continue;
                     queue.add(tc);
                        //更新推箱子的步数
                      dis.put(tc,dis.get(code)+1);
                    }
                    //下一个状态没有箱子
                    else {
                        int tc=encode(state[0],state[1],x,y);
                        //比之前的步数长
                        if(dis.containsKey(tc)&&dis.get(code)>=dis.get(tc)) continue;
                        queue.add(tc);
                        dis.put(tc,dis.get(code));
                    }
                }
            }
        }
return  res==Integer.MAX_VALUE?-1:res;
    }*/


    //编码解码方法好评
    //解码状态
    int encode(int boxX,int boxY,int playerX,int playerY){
         return (boxX<<24)|(boxY<<16)|(playerX<<8)|playerY;
    }
//将状态编码
    int []decode(int code){
        int[]res=new int[4];
        res[0]=(code>>>24)&0xff;
        res[1]=(code>>>16)&0xff;
        res[2]=(code>>>8)&0xff;
        res[3]=(code)&0xff;
        return res;
    }

    int[][] next = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    //BFS  以箱子状态为主
    //这个更像BFS
    public int minPushBox(char[][] grid) {
       
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        int res=0;
        int[] taget = new int[2], box = new int[2], player = new int[2];
        //查找相应的点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'T') taget = new int[]{i, j};
                if (grid[i][j] == 'B') box = new int[]{i, j};
                if (grid[i][j] == 'S') player = new int[]{i, j};
            }
        }
        queue.add(encode(box[0],box[1],player[0],player[1]));
        while (!queue.isEmpty()){
            int size=queue.size();res++;
            while (size-->0) {
                int code = queue.poll();
                if (set.contains(code)) continue;

                int[] state = decode(code);
                int boxX = state[0], boxY = state[1], playerX = state[2], playerY = state[3];
                boolean[][] canVisited = new boolean[grid.length][grid[0].length];
                checkVisited(canVisited, grid, playerX, playerY, boxX, boxY);
                for (int i = 0; i < next.length; i++) {
                    int newBoxX = boxX + next[i][0], newBoxY = boxY + next[i][1];
                    int prePlayerX = boxX - next[i][0], prePlayerY = boxY - next[i][1];
                    int preCode = encode(boxX, boxY, prePlayerX, prePlayerY);
                   //这个状态已经搜索过
                    if (set.contains(preCode)) continue;
                    //新状态越界或无法达到
                    if (newBoxX < 0 || newBoxX >= grid.length || newBoxY < 0 || newBoxY >= grid[0].length || grid[newBoxX][newBoxY] == '#') continue;
                    if (prePlayerX < 0 || prePlayerX >= grid.length || prePlayerY < 0 || prePlayerY >= grid[0].length || !canVisited[prePlayerX][prePlayerY])continue;

                    //找到结果  因为是BFS 直接返回
                    if (newBoxX == taget[0] && newBoxY == taget[1]) return res;

                    //把新状态添加
                    int newCode = encode(newBoxX, newBoxY, boxX, boxY);
                    queue.add(newCode);
                    set.add(preCode);
                }
            }
        }
        return -1;
    }

    //BFS设置可达到矩阵
    void checkVisited(boolean[][]canVisited,char[][]grid, int playerX,int playerY,int boxX,int boxY){
        if(playerX<0||playerX>=grid.length||playerY<0||playerY>=grid[0].length||grid[playerX][playerY]=='#'||(playerX==boxX&&playerY==boxY)||canVisited[playerX][playerY]) return;

        canVisited[playerX][playerY]=true;
        for (int i = 0; i < next.length; i++) {
          checkVisited(canVisited,grid,playerX+next[i][0],playerY+next[i][1],boxX,boxY);
        }
    }
}
