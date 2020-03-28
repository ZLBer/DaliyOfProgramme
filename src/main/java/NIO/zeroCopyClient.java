package NIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class zeroCopyClient {
    public static void main(String[] args) throws IOException {
       SocketChannel socketChannel= SocketChannel.open();

       socketChannel.connect(new InetSocketAddress("127.0.0.1",666));
       String file="D:\\a.txt";

        FileChannel channel= new FileInputStream(file).getChannel();

        long size=channel.transferTo(0,channel.size(),socketChannel);

    }
}
