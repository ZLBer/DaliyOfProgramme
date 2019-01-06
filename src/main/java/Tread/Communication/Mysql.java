package Tread.Communication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by libin on 2018/6/28.
 */
public class Mysql {
    public static void addOrder(TOrder tOrder){
        DBConnection DB=new DBConnection();
        Connection conn = DBConnection.getConnection();

        int i = 0;
        String sql = "insert into torder (userid,finaladdress,frequencyid,price,state) values(?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1,tOrder.getUserid());
            pstmt.setString(2, tOrder.getFinaladdress());
            pstmt.setInt(3, tOrder.getFrequencyid());
            pstmt.setDouble(4, tOrder.getPrice());
            pstmt.setInt(5, tOrder.getState());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                TOrder t=new TOrder();
//                t.setFinaladdress("test");
//                t.setFrequencyid(12);
//                t.setPrice(12.12);
//                t.setState(0);
//                t.setUserid(12);
//                long  begin=System.currentTimeMillis();
//                for(int i=0;i<=1000;i++){
//                    addOrder(t);
//                }
//                long  end=System.currentTimeMillis();
//                System.out.println(end-begin);
//            }
//        }
//        );
//        thread.start();

        for(int i=0;i<5;i++) {

            Thread thread1 = new Thread(new Runnable() {

                @Override
                public void run() {
                    long begin = System.currentTimeMillis();
                    TOrder t = new TOrder();
                    t.setFinaladdress("test");
                    t.setFrequencyid(12);
                    t.setPrice(12.12);
                    t.setState(0);
                    t.setUserid(12);

                    for (int i = 0; i <= 200; i++) {
                        addOrder(t);
                    }
                    long end = System.currentTimeMillis();
                    System.out.println(end - begin);
                }
            }
            );
            thread1.start();


        }


    }
}
