package netty.netty_http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

public class ServerHandler extends SimpleChannelInboundHandler<HttpObject> {


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    //读取客户端
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {

        //判断msg是不是httpRequest请求

        if(httpObject instanceof HttpRequest){

            String s=Thread.currentThread().getName();
            System.out.println(s);
            System.out.println("类型："+httpObject.getClass());
            System.out.println("客户端地址"+channelHandlerContext.channel().remoteAddress());

            HttpRequest httpRequest=(HttpRequest)httpObject;

            URI uri=new URI(httpRequest.uri());

            if("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求了，不做相应");
                return;
            }




            ByteBuf content= Unpooled.copiedBuffer("hello,我是服务器",CharsetUtil.UTF_16);

            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());


            //将构建好的response返回

            channelHandlerContext.writeAndFlush(response);
            channelHandlerContext.channel().writeAndFlush(response);


        }

    }
}
