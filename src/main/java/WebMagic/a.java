package WebMagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ListIterator;

public class a  implements PageProcessor {
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
        Elements content = doc.select("li>a");

        for (ListIterator<Element> it = content.listIterator(); it.hasNext(); ) {
            Element e = it.next();
            String href= "http://www.pm25.in"+e.attr("href");
            System.out.println(href);
            Spider.create(new pm35()).addUrl(href).thread(5).run();
        }


    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取");
        startTime = System.currentTimeMillis();
        Spider.create(new a()).addUrl("http://www.pm25.in/").thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束" + ((endTime - startTime) / 1000) + "秒");
    }
}
