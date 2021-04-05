package javaPractice.simple.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javaPractice.simple.xstream.conver.DateSingleValueConverter;
import javaPractice.simple.xstream.conver.MyConverter;

import java.util.Date;

public class XStreamTest {
    public static void main(String[] args) {
//        XStream xStream =new XStream(new Xpp3Driver());
        XStream xStream =new XStream(new DomDriver());

        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(new Class[]{Person.class});
//        xStream.allowTypesByRegExp(new String [] {".*"} );
        xStream.alias("Person",Person.class);

        xStream.registerConverter(new DateSingleValueConverter());

        /** 没使用  默认作为子节点*/
        xStream.useAttributeFor(Person.class,"personid");
        Person p = origizPerson();
        String result = xStream.toXML(p);
        System.out.println("===>"+result);

        Person per =(Person)xStream.fromXML(result);
        System.out.println(per);
    }

    public static Person origizPerson(){
        Person p = new Person();
        p.setPersonid("2");
        p.setAddress("上海");
        p.setEmail("54332@qq.com");
        p.setTel("87654343");
        p.setName("X stream");
        p.setDate(new Date());
        return  p;
    }

}
