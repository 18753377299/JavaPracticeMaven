package javaPractice.reptile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Api(value="Java 的HTML解析器")
public class JsoupTest {
    /**
     * 虽然使用Jsoup可以替代HttpClient直接发起请求解析数据，但是往往不会这样用，
     * 因为实际的开发过程中，需要使用到多线程，连接池，代理等等方式，
     * 而jsoup对这些的支持并不是很好，所以我们一般把jsoup仅仅作为Html解析工具使用
     */
    static String filePath = null;
    static {
        filePath = "C:\\Users\\lqk\\Desktop\\itcast.html";
    }



    public static void main(String[] args) {
//        testJsoup();
//        testJsoupString();
        testSelector();
    }

    public static void testJsoup(){
        try {
            String url = "http://www.itcast.cn/";
            //    解析url地址
            Document document = Jsoup.parse(new URL(url), 1000);
            //获取title的内容
            Element title = document.getElementsByTag("title").first();
            System.out.println(title.text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testJsoupString() {
        try {

            //读取文件获取
            String html = FileUtils.readFileToString(
                    new File(filePath), "UTF-8");

            //    解析字符串
            Document document = Jsoup.parse(html);
            //    解析文件
//            Document document = Jsoup.parse(new File(filePath),"UTF-8");


            //获取title的内容
            Element title = document.getElementsByTag("title").first();
            System.out.println(title.text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**    元素获取
     1.	根据id查询元素getElementById
     2.	根据标签获取元素getElementsByTag
     3.	根据class获取元素getElementsByClass
     4.	根据属性获取元素getElementsByAttribute
     */
    @ApiOperation(value="使用dom方式遍历文档")
    public static void testDom(){
        Document document = null;
        Element element = null;
        try {
            document = Jsoup.parse(new File(filePath),"UTF-8");
            //1.    根据id查询元素getElementById
            element = document.getElementById("city_bj");
            //2.   根据标签获取元素getElementsByTag
            element = document.getElementsByTag("title").first();

            //3.   根据class获取元素getElementsByClass
            element = document.getElementsByClass("s_name").last();

            //4.   根据属性获取元素getElementsByAttribute
            element = document.getElementsByAttribute("abc").first();
            element = document.getElementsByAttributeValue("class", "city_con").first();

           /** 元素中获取数据
            1.	从元素中获取id
            2.	从元素中获取className
            3.	从元素中获取属性的值attr
            4.	从元素中获取所有属性attributes
            5.	从元素中获取文本内容text
            */
            //获取元素
            Element element2 = document.getElementById("test");
            //1.   从元素中获取id
            String str = element2.id();
            //2.   从元素中获取className
            str = element2.className();
            //3.   从元素中获取属性的值attr
            str = element2.attr("id");
            //4.   从元素中获取所有属性attributes
            str = element2.attributes().toString();
            //5.   从元素中获取文本内容text
            str = element2.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @ApiOperation(value="5.2.6. Selector选择器概述和5.2.7. Selector选择器组合使用")
    public static void testSelector(){
        try {
            Document document = Jsoup.parse(new File(filePath),"UTF-8");
            //tagname: 通过标签查找元素，比如：span
            Elements span = document.select("span");
            for (Element element : span) {
                System.out.println(element.text());
            }
            //#id: 通过ID查找元素，比如：#city_bjj
            String str = document.select("#city_bj").text();
            //.class: 通过class名称查找元素，比如：.class_a
            str = document.select(".class_a").text();

            //[attribute]: 利用属性查找元素，比如：[abc]
            str = document.select("[abc]").text();

            //[attr=value]: 利用属性值来查找元素，比如：[class=s_name]
            str = document.select("[class=s_name]").text();

            /**5.2.7. Selector选择器组合使用 begin*/
            //el#id: 元素+ID，比如： h3#city_bj
            String strTwo = document.select("h3#city_bj").text();

            //el.class: 元素+class，比如： li.class_a
            strTwo = document.select("li.class_a").text();

            //el[attr]: 元素+属性名，比如： span[abc]
            strTwo = document.select("span[abc]").text();

            //任意组合，比如：span[abc].s_name
            strTwo = document.select("span[abc].s_name").text();

            //ancestor child: 查找某个元素下子元素，比如：.city_con li 查找"city_con"下的所有li
            strTwo = document.select(".city_con li").text();

            //parent > child: 查找某个父元素下的直接子元素，
            //比如：.city_con > ul > li 查找city_con第一级（直接子元素）的ul，再找所有ul下的第一级li
            strTwo = document.select(".city_con > ul > li").text();

            //parent > * 查找某个父元素下所有直接子元素.city_con > *
            strTwo = document.select(".city_con > *").text();

            /**5.2.7. Selector选择器组合使用 end*/
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
