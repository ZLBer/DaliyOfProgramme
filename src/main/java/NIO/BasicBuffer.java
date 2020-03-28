package NIO;

import java.io.IOException;

public class BasicBuffer {


    public static void main(String[] args) throws IOException {
     /*   IntBuffer intBuffer=IntBuffer.allocate(5);

        for(int i=0;i<intBuffer.capacity();i++){
            intBuffer.put(i*2);
        }
        //读写切换   读转写
       intBuffer.flip();

        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
            intBuffer.get(1);
        }*/


        /*  
       1. 本地写文件
         */  
/*        FileOutputStream fileOutputStream=new FileOutputStream("D:\\a.txt");
        FileChannel channel = fileOutputStream.getChannel();

        //创建缓冲
       ByteBuffer byteBuffer= ByteBuffer.allocate(1024);

        //放入
       byteBuffer.put("123".getBytes());

        //反转
      byteBuffer.flip();

        channel.write(byteBuffer);

        fileOutputStream.close();*/

      /*
       2.读本地写文件
         */
/*      FileInputStream fileInputStream=new FileInputStream("D:\\a.txt");
      FileChannel channel=fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.putLong(12L);
        System.out.println(channel.read(byteBuffer));
        System.out.println(channel.read(byteBuffer));
        System.out.println(new String(byteBuffer.array()));*/


/*  
 *    
 多个buffer读取数据
 */  
/*        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(2000);

        SocketChannel socketChannel = serverSocketChannel.bind(inetSocketAddress).accept();

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);

        while (true) {
            System.out.println("while");
            socketChannel.read(byteBuffers);
            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }


        }*/
    }


}
