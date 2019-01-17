package WebMagic;

import org.apache.log4j.Logger;
import redis.jedisCluster;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * Created by libin on 2019/1/8.
 */
public class ConsolePipeline implements Pipeline {
    jedisCluster  jedisClus=new jedisCluster();
    private static Logger logger = Logger.getLogger(ConsolePipeline.class);
    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
             String key=entry.getKey();
             String value=entry.getValue().toString();

            jedisClus.jedis.set(key,value);
            logger.info("===="+key+"    "+value+" 插入redis成功");
        }
    }
}
