package netty.netty_heartbeat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class HeartbeatHandlerInitializer extends ChannelInitializer<Channel> {

    private static final int READ_IDEL_TIME_OUT = 4; //4s 读超时
    private static final int WRITE_IDEL_TIME_OUT = 5;//5s 写超时
    private static final int ALL_IDEL_TIME_OUT = 7; // 7s 所有超时

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(READ_IDEL_TIME_OUT,
                WRITE_IDEL_TIME_OUT, ALL_IDEL_TIME_OUT, TimeUnit.SECONDS)); // 1
        pipeline.addLast(new HeartbeatServerHandler()); // 2
    }
}
