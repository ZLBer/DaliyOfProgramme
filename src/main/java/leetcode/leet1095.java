package leetcode;

public class leet1095 {
     class MountainArray {
       int get(int index) {return 0;}
       int length() {return  0;}
  }
    public int findInMountainArray(int target, MountainArray mountainArr) {

         int Mountain=-1;
        int left=0,right=mountainArr.length()-1;
        Integer []arr=new Integer[mountainArr.length()];
        while (left<=right){
            int mid=(left+right)/2;
            //System.out.println(left+" "+right+" "+mid);
            if(mid==0) mid++;  //防止溢出
            if(mid==mountainArr.length()-1) mid--;
            int midNum=mountainArr.get(mid);
            int lefNum=mountainArr.get(mid-1);
            int rigNum=mountainArr.get(mid+1);
           // System.out.println(lefNum+" "+midNum+" "+rigNum);
            if(midNum>lefNum&&midNum>rigNum){
                Mountain=mid;break;
            }else if(midNum<rigNum) { //递增
                left=mid+1;
            } else { //递减
                right=mid-1;
            }
        }
        //System.out.println(Mountain);
       int val= binary(0,Mountain,true,mountainArr,target);
        if(val==-1){
            return binary(Mountain+1,mountainArr.length()-1,false,mountainArr,target);
        }else {
            return val;
        }
    }

    int binary(int left,int right,boolean up,MountainArray mountainArray,int taget){
      while (left<=right){
          int mid=(left+right)/2;
          if(mid==0) mid++;
          if(mid==mountainArray.length()-1) mid--;
          int midNum=mountainArray.get(mid);
          if(midNum==taget){
              return mid;
          }else if(midNum<taget){
              if(up) left=mid+1;
              else right=mid-1;
          }else {
              if(up) right=mid-1;
              else left=mid+1;
          }
      }
      return -1;
    }
    public static void main(String[] args) {
        System.out.println(1^1^2^3^15^3^15);
    }
}
