package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by libin on 2019/1/5.
 */
public class test {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "39.107.99.207:9092");
        props.put("group.id", "test");
/* 关闭自动确认选项 */
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test-lmx"));
        final int minBatchSize = 200;
        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                buffer.add(record);
            }
    /* 数据达到批量要求，就写入DB，同步确认offset */
            if (buffer.size() >= minBatchSize) {
                //  insertIntoDb(buffer);
                System.out.println(buffer);
                consumer.commitSync();
                buffer.clear();
            }

        }
    }
}
