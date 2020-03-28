package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient_copy {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch)  {

                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {


                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                for (int i = 0; i < 10; i++) {
                                    ctx.channel().writeAndFlush(Unpooled.copiedBuffer(("message "+i).getBytes()));
                                }
                            }

                        });
                    }
                });

        Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();
        channel.closeFuture().sync();

    }


}