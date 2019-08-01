package WebMagic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.List;


//爬取http://news.cnstock.com/news/sns_yw/index.html的宏观经济新闻
public class macrographyCnstock implements PageProcessor {

    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setCharset("GBK");
    private static int count =0;

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
       List<String >r= page.getJson().jsonPath("data.item").all();
      for(String s:r){
          JSONObject js= JSON.parseObject(s);
          System.out.print("id:"+js.get("id"));
          System.out.print("      title:"+js.get("title"));
          System.out.print("      time:"+js.get("time"));
          System.out.println("      link:"+js.get("link"));
      }

    }

    //测试方法
    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取");
        startTime = System.currentTimeMillis();
        int pageNumber=0;
        Request request = new Request("http://app.cnstock.com/api/waterfall?colunm=qmt-sns_yw&page="+pageNumber+"&num=10&showstock=0&_=1564025351206");
        request.setMethod(HttpConstant.Method.POST);
        request.addHeader("Referer","http://news.cnstock.com/news/sns_yw/index.html");
        Spider.create(new macrographyCnstock()).addRequest(request).thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束" + ((endTime - startTime) / 1000) + "秒");
    }
}
