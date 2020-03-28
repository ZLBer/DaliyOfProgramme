package netty.netty_rpc;

public class RPCClient {

    public static void main(String[] args){
        NoArgsHelloService noArgsHelloService = (NoArgsHelloService) ServiceProxy.create(NoArgsHelloService.class);
        System.out.println(noArgsHelloService.hello());

        HasArgsHelloService hasArgsHelloService = (HasArgsHelloService) ServiceProxy.create(HasArgsHelloService.class);
        System.out.println(hasArgsHelloService.hello("hello netty rpc"));
    }

}
