package WebMagic;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.LinkedList;

/**
 * Created by libin on 2019/1/15.
 */
public class btTianTang  implements PageProcessor {
    private static Logger logger = Logger.getLogger(btTianTang.class);
    static  int increasedId=21;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
      //转成jsoup格式
        Document doc = Jsoup.parse(page.getHtml().toString());
        //css选择器
         Elements elements = doc.select("li.post.box.row.fixed-hight");
       for(Element element:elements){
         String href=element.select("a").attr("href");
         page.putField((increasedId++)+"",href);
         logger.info("找到-->"+element.select("a").attr("href"));
       //  System.out.println(element.select("a").attr("href"));
     }
     //   System.out.println(elements.size());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        LinkedList<String> webs=new LinkedList<>();
        for(int i=2;i<=50;i++) {
            String web = "https://www.bttiantang.la/list/dianying/index_" + i + ".html";
            System.out.println(web);
           Spider.create(new btTianTang()).addUrl(web).addPipeline(new ConsolePipeline()).thread(5).run();
        }

    }
}