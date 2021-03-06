package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import netty.netty_encoder_decoder.ByteToIntegerDecoder;
import netty.netty_encoder_decoder.IntegerToByteEncoder;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NettyServer {
    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boos = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                .group(boos, worker)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))// ServerSocketChannel 专属
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                     //  ch.pipeline().addLast(new StringDecoder());
//                        ch.pipeline().addLast(new StringEncoder());
                        ch.pipeline().addLast(new ByteToIntegerDecoder());
                        ch.pipeline().addLast(new IntegerToByteEncoder());
                      //  ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO));
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println("ChannelInboundHandler 1:"+msg);
                              ctx.fireChannelRead(msg);//不调用肯定不会触发下一个 read 监听
                            }

                        });


                        ch.pipeline().addLast(new SimpleChannelInboundHandler<Integer>() {

                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, Integer msg) {
                                System.out.println("IntegerChannelInboundHandler ："+msg);
                                ctx.fireChannelRead(msg);
                            }
                        });

                        ch.pipeline().addLast(new SimpleChannelInboundHandler<Integer>() {

                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, Integer msg) {
                                System.out.println("IntegerChannelInboundHandler 2："+msg);
                                ctx.write(msg);                          }
                        });

                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println("ChannelInboundHandler 2："+msg);
                                ctx.channel().writeAndFlush(new Date() + ": Received world!");
                            }
                        });

                        ch.pipeline().addLast(new ChannelOutboundHandlerAdapter(){
                            @Override
                            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                                System.out.println("ChannelOutboundHandler 1:"+msg);
                                ctx.write(msg);
                            }
                        });
                        ch.pipeline().addLast(new ChannelOutboundHandlerAdapter(){
                            @Override
                            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                                System.out.println("ChannelOutboundHandler 2:"+msg);
                                ctx.write(msg);
                            }
                        });
                    }
                })
                .bind(8000);
    }
}
