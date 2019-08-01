package WebMagic;


import com.alibaba.fastjson.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class pm35 implements PageProcessor {
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setCharset("UTF-8");
    private static int count =0;
   public JSONArray jsonArray= new JSONArray();
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
        Elements content = doc.select("body > div.container > div.span12.avg > div.span12.data > div:nth-child(2) > div.value");
        String pm=content.text();
         content= doc.select("body > div.container > div.span12.avg > div:nth-child(1) > div.city_name > h2");
        String area=content.text();
        System.out.println(area+"  "+pm);

        String json="{\"name\":\""+area+"\",\"selected\":false,\"value\":"+pm+",\"province\":\""+area+"\"}";
        jsonArray.add(json);
//        for(Element e:content){
//            //   System.out.println(e.select(" tbody > tr > td:nth-child(2) > div > a"));
//            //    System.out.println(e.select(" tbody > tr > td:nth-child(2) > div > a").text());
//            //将数据放到pipeline中去 key-value类型
//            page.putField(id+"",e.select(" tbody > tr > td:nth-child(2) > div > a").text()+"           "+e.select(" tbody > tr > td:nth-child(2) > div > p").text()+"     "+e.select(" tbody > tr > td:nth-child(2) > div > div").text());
//            id++;
//        }
    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取");
        startTime = System.currentTimeMillis();
        Spider.create(new pm35()).addUrl("http://www.pm25.in/abazhou").thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束" + ((endTime - startTime) / 1000) + "秒");
    }

}
