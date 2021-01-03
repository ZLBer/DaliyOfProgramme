package leetcode;

public class leet1701 {
    public double averageWaitingTime(int[][] customers) {
     long res=0;

       int time=0;
        for (int i = 0; i < customers.length; i++) {
            int[] customer = customers[i];

           time=Math.max(customer[0],time)+customer[1];

           res+=(time-customer[0]);

        }

        return (double) res/customers.length;
     
    }
}
