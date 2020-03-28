package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //Selector
        Selector selector = Selector.open();
        //监听
        serverSocketChannel.socket().bind(new InetSocketAddress(600));
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);

        //注册serverSocketChannel关心accept时间
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            if(selector.select(100)==0) {
                continue;
            }
            //如果返回的大于0,表示已经获取到关注的时间
            // 关注事件的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                SelectionKey selectionKey = keyIterator.next();
                //根据key对用的通道做相应的处理
                if(selectionKey.isAcceptable()){
                    //拿到客户端通道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    //绑定关注事件,设置buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端上线"+socketChannel.getRemoteAddress());
                }else if(selectionKey.isReadable()){
                    System.out.println("读取测试");
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    //获取到该channal的buffer

                    readData(selectionKey,selector);

                }else if(selectionKey.isWritable()){
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    ByteBuffer byteBuffer=ByteBuffer.wrap("12".getBytes());
                    channel.write(byteBuffer);
                }
                keyIterator.remove();
            }

        }
    }

 static   private void readData(SelectionKey key,Selector selector){
        SocketChannel channel=null;

        channel=(SocketChannel)key.channel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        try {
            int count=channel.read(byteBuffer);
            if(count>0){
                String msg=new String(byteBuffer.array());
                System.out.println("from 客户端"+msg);

                //向其他客户端转发消息
             sendInfoToOtherClient(msg,channel,selector);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //转发消息给其他客户端
   static private void sendInfoToOtherClient(String msg,SocketChannel self,Selector selector){
        System.out.println("服务器转发消息");
        //遍历所有注册到
        for(SelectionKey selectionKey:selector.keys()){
            Channel tagetChanal=selectionKey.channel();
            //排除自己
            if(tagetChanal instanceof  SocketChannel&&tagetChanal!=self){
                SocketChannel socketChannel=(SocketChannel)tagetChanal;
                ByteBuffer byteBuffer=ByteBuffer.wrap(msg.getBytes());
                try {
                    socketChannel.write(byteBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
