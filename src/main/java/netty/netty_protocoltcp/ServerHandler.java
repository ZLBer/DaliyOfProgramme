package netty.netty_protocoltcp;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.nio.charset.Charset;
import java.util.UUID;

public class ServerHandler extends SimpleChannelInboundHandler<MessageProtocol> { // (1)

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

private int count=0;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol s) throws Exception { // (4)
        Channel incoming = ctx.channel();

     int len=s.getLen();
     byte[]content=s.getContent();
        System.out.println("长度："+len);
        System.out.println("内容："+new String(content, Charset.forName("utf-8")));
        System.out.println("接收到消息次数："+(++this.count));

        //回送消息
        String responseContent= UUID.randomUUID().toString();
        MessageProtocol messageProtocol=new MessageProtocol();
        messageProtocol.setContent(responseContent.getBytes(Charset.forName("utf-8")));
        messageProtocol.setLen(responseContent.getBytes("utf-8").length);
        ctx.writeAndFlush(messageProtocol);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (7)
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
