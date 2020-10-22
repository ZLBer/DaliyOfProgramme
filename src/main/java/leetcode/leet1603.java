package leetcode;

public class leet1603 {
    class ParkingSystem {
        int big,medium,small;
         public ParkingSystem(int big, int medium, int small) {
          this.big=big;
          this.medium=medium;
          this.small=small;
        }

        public boolean addCar(int carType) {
         switch (carType){
             case 1:{
                 if(big>0) big--;
                 else return false;
               break;
               }
             case  2:{
                 if(medium>0) medium--;
                 else return false;
                 break;
             }
             default:{
                 if(small>0) small--;
                 else return false;
             }

         }
         return true;
        }
    }
}
