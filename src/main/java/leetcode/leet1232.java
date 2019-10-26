package leetcode;

public class leet1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        double xieLv=0;
        double coreX=coordinates[0][0],coreY=coordinates[0][1];
        xieLv=(coordinates[1][1]-coreY)/(coordinates[1][0]-coreX);
        for (int i = 2; i < coordinates.length; i++) {
            double x=coordinates[i][0];
            double y=coordinates[i][1];
            double tem=(y-coreY)/(x-coreX);
            if(tem!=xieLv) return false;
        }
        return true;
    }
}
