package netty.netty_rpc;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class RPCClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * RPC调用返回的结果
     */
    private Object rpcResult;

    public Object getRpcResult() {
        return rpcResult;
    }

    public void setRpcResult(Object rpcResult) {
        this.rpcResult = rpcResult;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        setRpcResult(msg);
        ctx.close();
    }
}

