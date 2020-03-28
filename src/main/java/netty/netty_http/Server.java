package netty.netty_http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Server {
    volatile int a=1;
    public static void main(String[] args) throws Exception{
        EventLoopGroup bossGroup=new NioEventLoopGroup(4);
        EventLoopGroup workGroup=new NioEventLoopGroup(8);
        AtomicIntegerFieldUpdater<Server> updater=AtomicIntegerFieldUpdater.newUpdater(Server.class,"a");
        try {
            ServerBootstrap bootStrap=new ServerBootstrap();

            bootStrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer());


         ChannelFuture channelFuture= bootStrap.bind(8080).sync();
         channelFuture.channel().closeFuture().sync();
        }

        finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
