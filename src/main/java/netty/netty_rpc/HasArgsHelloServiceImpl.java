package netty.netty_rpc;

public class HasArgsHelloServiceImpl implements HasArgsHelloService {

    @Override
    public String hello(String msg) {
        return msg;
    }
}
