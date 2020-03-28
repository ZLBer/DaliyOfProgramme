package netty.netty_groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    private  static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");




    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String o) throws Exception {
        Channel channel = channelHandlerContext.channel();

        //遍历channalGroup
        channelGroup.forEach(channel1 -> {
            if(channel1!=channel){
                channel1.writeAndFlush("[客户端]"+channel.remoteAddress()+"说："+o);
            }else {
                channel.writeAndFlush("[自己]说："+o);
            }
        });
    }


    //表示连接建立  加入到group里面
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //遍历所有channal发送消息
        channelGroup.writeAndFlush("[客户端]"+ctx.channel().remoteAddress()+"加入聊天\n");
        channelGroup.add(ctx.channel());
    }


    //提示xx上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"上线了");
    }


    //提示XX下线
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"离线了");
    }


    //表示断开连接了
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
       channelGroup.writeAndFlush("[客户端]"+ctx.channel().remoteAddress()+"离开了聊天！\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
