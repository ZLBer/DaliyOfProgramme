package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        //

        Selector selector=Selector.open();

       // SocketChannel socketChannel = SocketChannel.open();

      //  socketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 600);
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
        socketChannel.configureBlocking(false);
        //socketChannel.connect(inetSocketAddress);
        socketChannel.register(selector, SelectionKey.OP_READ);


       new Thread(){
           @Override
           public void run() {
               while (true){
                   readInfo(selector);
               }
           }
       }.start();


        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            sendinfo(scanner.nextLine(),socketChannel);
        }



    }

    static  public void sendinfo(String info,SocketChannel socketChannel){
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  static   public  void  readInfo(Selector selector){
        try {
            int readChannals=selector.select();
            if(readChannals>0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
               while (iterator.hasNext()){
                   SelectionKey key = iterator.next();
                   if(key.isReadable()){
                     SocketChannel socketChannel= (SocketChannel) key.channel();
                       ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                       socketChannel.read(byteBuffer);
                       String msg=new String(byteBuffer.array(), Charset.forName("utf-8"));
                       System.out.println(msg);
                       iterator.remove();
                   }
               }
            }else {
                System.out.println("没有消息");
                Thread.currentThread().sleep(3000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
  }
}
