package WebMagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

//爬取https://tks.mysteel.com/的宏观经济新闻
public class macrographyTks_test implements PageProcessor {
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setCharset("GBK");
    private static int count =0;

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        //jsoop获取页面
        Document doc = Jsoup.parse(page.getHtml().toString());
        //css选择器
        Elements content = doc.select("#list > li");
        for(Element e:content){
            //将数据放到pipeline中去 key-value类型
//            page.putField(id+"",e.select(" tbody > tr > td:nth-child(2) > div > a").text()+"           "+e.select(" tbody > tr > td:nth-child(2) > div > p").text()+"     "+e.select(" tbody > tr > td:nth-child(2) > div > div").text());
//            id++;
            System.out.println(e.select("li > h3 > a").text());
            System.out.println(e.select("li > h3 > a").attr("href"));
            System.out.println(e.select("li > h3 > p").text());
        }

        System.out.println(page.getHtml().links().all());
        page.addTargetRequests(page.getHtml().links().regex("(https://list1\\.mysteel\\.com/article/p-401-------------1\\.html\\?channelId=401\\&includeChild=true\\&page=[0-9]{1,})").all());
    }
    //测试方法
    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取");
        startTime = System.currentTimeMillis();
        int pageNumber=0;
        Spider.create(new macrographyTks_test()).addUrl("https://list1.mysteel.com/article/p-401-------------1.html?channelId=401&includeChild=true&page="+pageNumber).setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(1000))).thread(20).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束" + ((endTime - startTime) / 1000) + "秒");
    }
}
