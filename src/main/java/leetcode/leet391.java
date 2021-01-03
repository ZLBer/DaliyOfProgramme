package leetcode;

import java.util.Arrays;

public class leet391 {

    //mine 就强行遍历嘛..
    static public boolean isRectangleCover(int[][] rectangles) {
        //按照先下后上 先左后右排序
        Arrays.sort(rectangles, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        //求边界
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < rectangles.length; i++) {
            left = Math.min(rectangles[i][0], left);
            right = Math.max(rectangles[i][2], right);
            min = Math.min(min, rectangles[i][1]);
            max = Math.max(max, rectangles[i][3]);

        }
        //计算偏移量  因为有负数点
        int move = Math.max(0, -left);

        int[] tops = new int[right + move];
        for (int i = left; i < right; i++) {
            tops[i + move] = min - 1;
        }

        //遍历更新上界
        for (int i = 0; i < rectangles.length; i++) {
            int down = rectangles[i][1], up = rectangles[i][3] - 1;
            for (int j = rectangles[i][0]; j < rectangles[i][2]; j++) {
               //上下界必须要连贯 否则直接false
                if (tops[j + move] + 1 == down) {
                    tops[j + move] = up;
                } else {
                    return false;
                }
            }
        }
        for (int i = left; i < right; i++) {
            if (tops[i + move] != max - 1) return false;
        }
        return true;
    }



    //另一种思路  判断面积和重合点的数目
   /* public boolean isRectangleCover(int[][] rectangles) {
        // 完美矩形的左下角和右上角坐标
        int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;

        // 小矩形面积之和
        int areas = 0;
        // 记录所有顶点的出现情况
        Set<String> points = new HashSet<>();
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
            // 更新坐标
            X1 = Math.min(x1, X1);
            Y1 = Math.min(y1, Y1);
            X2 = Math.max(x2, X2);
            Y2 = Math.max(y2, Y2);

            areas += (x2 - x1) * (y2 - y1);
            // 判断顶点是否出现过
            String[] ps = {x1 + " " + y1, x2 + " " + y2, x1 + " " + y2, x2 + " " + y1};
            for (String s : ps) {
                // 没有出现过，添加；否则，移除
                if(points.contains(s)){
                    points.remove(s);
                } else {
                    points.add(s);
                }
            }
        }

        // 面积是否相等
        int expected = (X2 - X1) * (Y2 -Y1);
        if(areas != expected){
            return false;
        }
        // 顶点情况是否满足
        if(points.size() != 4 || !points.contains(X1 + " " + Y1) || !points.contains(X2 + " " + Y2) || !points.contains(X1 + " " + Y2) || !points.contains(X2 + " " + Y1)){
            return false;
        }
        return true;
    }
*/

    public static void main(String[] args) {
        isRectangleCover(new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        });
    }
}
