package netty.netty_rpc;

public class NoArgsHelloServiceImpl implements NoArgsHelloService {

    @Override
    public String hello() {
        return "hello";
    }
}



