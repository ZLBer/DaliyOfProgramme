package WebMagic;

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

/**
 * Created by libin on 2019/1/10.
 */
public class leetcodeProblems implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setCharset("UTF-8");
    private static int count =0;

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        int id=1;
        Document doc = null;
        //jsoop获取页面
        System.out.println(page.getJson().toString());
        doc = Jsoup.parse(page.getHtml().toString());
        //css选择器
   //     Elements content = doc.select("#question-app > div > div:nth-child(2) > div.question-list-base > div.table-responsive.question-list-table > table > tbody.reactable-data > tr:nth-child(1)");
    //    System.out.println(content);

//
//                for(Element e:content){
//               System.out.println(e.text());
//
//        }
    }
/*  
 *    
 *   
 * @author BNer  
 * @date 2019/1/19 20:06
 * @param [args]  
 * @return void
 *  利用json模拟Post请求
 */  
        public static void main(String[] args) {
            long startTime, endTime;
            System.out.println("开始爬取");
            startTime = System.currentTimeMillis();

            Request request = new Request("https://leetcode.com/graphql");
            request.setMethod(HttpConstant.Method.POST);
            request.addHeader("accept","application/json");
            request.setRequestBody(HttpRequestBody.json("{\"operationName\":\"getQuestionDetail\",\"variables\":{\"titleSlug\":\"jewels-and-stones\"},\"query\":\"query getQuestionDetail($titleSlug: String!) {\\n  isCurrentUserAuthenticated\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    questionTitle\\n    translatedTitle\\n    questionTitleSlug\\n    content\\n    translatedContent\\n    difficulty\\n    stats\\n    allowDiscuss\\n    contributors {\\n      username\\n      profileUrl\\n      __typename\\n    }\\n    similarQuestions\\n    mysqlSchemas\\n    randomQuestionUrl\\n    sessionId\\n    categoryTitle\\n    submitUrl\\n    interpretUrl\\n    codeDefinition\\n    sampleTestCase\\n    enableTestMode\\n    metaData\\n    langToValidPlayground\\n    enableRunCode\\n    enableSubmit\\n    judgerAvailable\\n    infoVerified\\n    envInfo\\n    urlManager\\n    article\\n    questionDetailUrl\\n    libraryUrl\\n    companyTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    __typename\\n  }\\n  interviewed {\\n    interviewedUrl\\n    companies {\\n      id\\n      name\\n      slug\\n      __typename\\n    }\\n    timeOptions {\\n      id\\n      name\\n      __typename\\n    }\\n    stageOptions {\\n      id\\n      name\\n      __typename\\n    }\\n    __typename\\n  }\\n  subscribeUrl\\n  isPremium\\n  loginUrl\\n}\\n\"}\n","UTF-8"));
            Spider.create(new leetcodeProblems()).addRequest(request).thread(5).run();
            endTime = System.currentTimeMillis();
            System.out.println("爬取结束" + ((endTime - startTime) / 1000) + "秒");
        }

    }
