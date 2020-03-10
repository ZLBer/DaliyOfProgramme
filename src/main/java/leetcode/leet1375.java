package leetcode;

public class leet1375 {
    //mine 线性
/*    public int numTimesAllBlue(int[] light) {
        boolean []isOn=new boolean[light.length+1];
        boolean[]isBlue=new boolean[light.length+1];
         isBlue[0]=true;
        int maxIndex=0;
        int res=0;
        for (int i = 0; i < light.length; i++) {
            int index=light[i];
            maxIndex=Math.max(maxIndex,index);
            isOn[index]=true;
            //若前一个是蓝灯，这个就可变蓝
            if(isBlue[index-1]){
                isBlue[index]=true;
                //遍历后边开的等
                while (index+1<=light.length&&isOn[index+1]) isBlue[(index++)+1]=true;
            }

            if(isBlue[maxIndex]) res++;//只要最大的等是蓝色就可以

        }
        return res;
    }*/

    //woc 原来可以这样  最大值等于遍历位置的大小就表示可以全部点亮
    public int numTimesAllBlue(int[] light) {
        int right=0,res=0;
        for(int i=0;i<light.length;i++){
            right=Math.max(right,light[i]);
            if(right==i+1) res++;
        }
        return res;
    }
}
