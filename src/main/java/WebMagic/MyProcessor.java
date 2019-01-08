package WebMagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.IOException;

/**
 * Created by libin on 2019/1/8.
 */
public class MyProcessor implements PageProcessor {
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setCharset("UTF-8");
    private static int count =0;

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
      //  System.out.println( page.getHtml().css("#content > div > div.article > div > div > table:nth-child(2) > tbody > tr > td:nth-child(2) > div").css(""));
   int id=1;
        Document doc = null;
       //jsoop获取页面
        doc = Jsoup.parse(page.getHtml().toString());
 //css选择器
        Elements content = doc.select("#content > div > div.article > div > div > table:nth-child(2)").nextAll("table");
           for(Element e:content){
            //   System.out.println(e.select(" tbody > tr > td:nth-child(2) > div > a"));
           //    System.out.println(e.select(" tbody > tr > td:nth-child(2) > div > a").text());
              //将数据放到pipeline中去 key-value类型
               page.putField(id+"",e.select(" tbody > tr > td:nth-child(2) > div > a").text()+"           "+e.select(" tbody > tr > td:nth-child(2) > div > p").text()+"     "+e.select(" tbody > tr > td:nth-child(2) > div > div").text());
               id++;
           }

    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取");
        startTime = System.currentTimeMillis();
        Spider.create(new MyProcessor()).addPipeline(new ConsolePipeline()).addUrl("https://movie.douban.com/chart").thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束" + ((endTime - startTime) / 1000) + "秒");
    }

}