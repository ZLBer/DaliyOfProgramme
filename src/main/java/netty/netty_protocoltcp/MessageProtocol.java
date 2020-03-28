package netty.netty_protocoltcp;

//协议包
public class MessageProtocol {
    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    private  int len;
    private  byte[]content;
}
