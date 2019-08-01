package WebMagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


//爬取https://jiancai.mysteel.com/的产业市场供需新闻
public class supplyMysteel implements PageProcessor {
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(2).setSleepTime(100).setCharset("GBK");
    private static int count =0;

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        int id=1;
        //jsoop获取页面
        Document doc = Jsoup.parse(page.getHtml().toString());
        //css选择器
        Elements content = doc.select("#articleList > ul > li");
        for(Element e:content){
            System.out.print(e.select("li>span").text());
            System.out.print(e.select("li>a").text());
            System.out.println(e.select("li>a").attr("href"));
        }

    }

    //测试方法
    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取");
        startTime = System.currentTimeMillis();
        int pageNumber=1;
        Spider.create(new supplyMysteel()).addUrl("https://list1.mysteel.com/article/p-12----010101---------"+pageNumber+".html").thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束" + ((endTime - startTime) / 1000) + "秒");
    }
}
