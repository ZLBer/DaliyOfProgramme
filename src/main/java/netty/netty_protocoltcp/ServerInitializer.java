package netty.netty_protocoltcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


//初始化Server端新接入的SocketChannel对象
public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
       pipeline.addLast(new MessageDecoder());
       pipeline.addLast(new MessageEncoder());
       pipeline.addLast(new ServerHandler());

    }
}
