package guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CatchTest {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(
                        new CacheLoader<Integer,String>() {

                            @Override
                            public String load(Integer key) throws Exception {
                                System.out.println("开始load");
                               return "load"+key;
                            }
                        });

        for (int i = 0; i < 50; i++) {
            cache.put(i,"test"+i);
        }
        for (int i = 0; i < 666; i++) {
            System.out.println(cache.get(i));
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(cache.get(i));
        }
    }



}
