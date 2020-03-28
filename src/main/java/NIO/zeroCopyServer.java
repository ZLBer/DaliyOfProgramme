package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class zeroCopyServer {
    public static void main(String[] args) throws IOException {
        InetSocketAddress socketAddress=new InetSocketAddress(666);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket serverSocket=serverSocketChannel.socket();
        serverSocket.bind(socketAddress);

        ByteBuffer byteBuffer=ByteBuffer.allocate(4096);

        while (true){
            SocketChannel socketChannel=serverSocketChannel.accept();

            int readcount=0;
            while (readcount!=-1){
                readcount=socketChannel.read(byteBuffer);


                byteBuffer.rewind();//position编程0；
            }
        }
    }
}
