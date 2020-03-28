package netty;

import com.google.common.base.Charsets;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServerc_copy {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boos = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup(4);
        serverBootstrap
                .group(boos, worker)
                .channel(NioServerSocketChannel.class)
               // .handler(new LoggingHandler(LogLevel.INFO))// ServerSocketChannel 专属
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                                         protected void initChannel(NioSocketChannel ch) {

                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf byteBuf=(ByteBuf)msg;
                                System.out.println(byteBuf.toString(Charsets.UTF_8));
                            }

                        });

                    }
                })
                .bind(8000);
    }
}
