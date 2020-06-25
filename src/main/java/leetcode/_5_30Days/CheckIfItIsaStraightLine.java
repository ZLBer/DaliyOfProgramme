package leetcode._5_30Days;

public class CheckIfItIsaStraightLine {
/*    public boolean checkStraightLine(int[][] coordinates) {
      double k=((double) coordinates[1][1]-coordinates[0][1])/(coordinates[1][0]-coordinates[0][0]);
        for (int i = 3; i < coordinates.length; i++) {
        if(((double) coordinates[i][1]-coordinates[0][1])/(coordinates[i][0]-coordinates[0][0])!=k) return false;
        }
        return true;
    }*/


//利用函数
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1], x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}
