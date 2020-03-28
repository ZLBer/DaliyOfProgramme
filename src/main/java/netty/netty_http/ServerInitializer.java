package netty.netty_http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //得到管道

        ChannelPipeline pipeline = socketChannel.pipeline();


        //加入netty提供的httpServerCodec
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        //增加自定义handler

        pipeline.addLast("自定义handler",new ServerHandler());
        pipeline.addLast("ssssssssssss",new HttpServerCodec());

    }
}
