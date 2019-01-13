package redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by libin on 2019/1/6.
 */
public class jedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis ("39.107.99.207",7005);
        //string 类型
        System.out.println(jedis.set("20156789","main"));
        System.out.println(jedis.get("20156789"));
        //hash类型

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "fujianchao");
        map.put("password", "123");
        map.put("age", "12");
        // 存入一个map
        jedis.hmset("user", map);
         System.out.println(jedis.hmset("hash", map));
  //list集合
        System.out.println(jedis.lpush("list","20187678"));
        System.out.println(jedis.rpush("list","20158909"));


        //set集合
        System.out.println(jedis.sadd("set","20187678"));
        System.out.println(jedis.sadd("set","20187678"));

   //zset  有序set
        System.out.println(jedis.zadd("zset",0,"20187678"));

        System.out.println(jedis.dbSize());







        jedis.connect();//连接

        jedis.disconnect();//断开连接



    }
}
