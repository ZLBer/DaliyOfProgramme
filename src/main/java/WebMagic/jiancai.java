package WebMagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class jiancai  implements PageProcessor {
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
        Elements content = doc.select("#articleList > ul > li");
        for(Element e:content){
            //将数据放到pipeline中去 key-value类型
//            page.putField(id+"",e.select(" tbody > tr > td:nth-child(2) > div > a").text()+"           "+e.select(" tbody > tr > td:nth-child(2) > div > p").text()+"     "+e.select(" tbody > tr > td:nth-child(2) > div > div").text());
//            id++;
           if( e.select("li > span").isEmpty()) continue;
            System.out.println(count++);
            System.out.println(e.select("li > span").text());
            System.out.println(e.select("li > a").text());
            System.out.println("https:"+e.select("li > a").attr("href"));
        }
    }
    //测试方法
    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取");
        startTime = System.currentTimeMillis();
        int pageNumber=0;
        Spider.create(new jiancai()).addUrl("https://list1.mysteel.com/market/p-228-15278-----0--------1.html").thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束" + ((endTime - startTime) / 1000) + "秒");
    }


}
