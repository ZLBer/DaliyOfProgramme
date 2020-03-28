package netty.netty_protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MessageDecoder extends ReplayingDecoder<MessageProtocol> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        //将得到的二进制自己码转成对象
        System.out.println("开始解吗");
        int length=byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        //封装成对象
        MessageProtocol messageProtocol=new MessageProtocol();
        messageProtocol.setLen(length);
        messageProtocol.setContent(bytes);
        list.add(messageProtocol);
    }
}
