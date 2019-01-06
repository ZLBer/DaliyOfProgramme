package kafka;

/**
 * Created by libin on 2019/1/5.
 */

public class ConfigureAPI
{

    public final static String GROUP_ID = "test";

    public final static String TOPIC = "my";

    public final static int BUFFER_SIZE = 64 * 1024;

    public final static int TIMEOUT = 20000;

    public final static int INTERVAL = 10000;

    public final static String BROKER_LIST = "39.107.99.207:9092";

    // 去数据间隔
    public final static int GET_MEG_INTERVAL = 1000;

}
