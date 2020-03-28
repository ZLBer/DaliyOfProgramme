package netty.netty_groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class GroupChatClient {
    private final String host;
    private final  int port;

    public GroupChatClient(String host,int port){
        this.host=host;
        this.port=port;
    }
    public  void run(){
        EventLoopGroup eventExecutors=new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast("decoder",new StringDecoder());
                        socketChannel.pipeline().addLast("encoder",new StringEncoder());
                        socketChannel.pipeline().addLast(new GroupChatClientHandler() );
                    }
                });
        try {
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            Channel channel=channelFuture.channel();
            Scanner scanner=new Scanner(System.in);
            while (scanner.hasNextLine()){
                String msg=scanner.nextLine();
                channel.writeAndFlush(msg+"\r\n");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            eventExecutors.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new GroupChatClient("127.0.0.1",7000).run();
    }
}
