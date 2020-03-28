package netty.netty_protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class ClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private  int count=0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol s) throws Exception {
        int len=s.getLen();
        byte[]content=s.getContent();
        System.out.println("长度："+len);
        System.out.println("内容："+new String(content,"utf-8"));
        System.out.println("客户端接收消息数量+"+(++count));
        ctx.fireChannelRead(s);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常："+cause.getMessage());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i=0;i<10;i++){
            String msg="今天天气冷，吃火锅";
            byte[] bytes = msg.getBytes(Charset.forName("utf-8"));

            //创建协议
            MessageProtocol messageProtocol=new MessageProtocol();
            messageProtocol.setContent(bytes);
            messageProtocol.setLen(bytes.length);
            ctx.writeAndFlush(messageProtocol);
        }
    }
}
