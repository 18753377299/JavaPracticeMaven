package javaPractice.simple.listFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
* @author  作者 E-mail:
* @date 创建时间：2017年12月11日 下午4:08:40
* @version 1.0
* @parameter
* @since  主要是List方法中remove的用法
* @return  */
public class ListRemoveTest {
public static void main(String[]args){
   List books=new ArrayList();
   books.add("aaa");
   books.add("bbbb");
   books.add("ccccc");
   JSONObject audienceAll = new JSONObject();
   JSONArray baseform = new JSONArray();
   for(Object str: books){
       baseform.add(str) ;
   }
   audienceAll.put("vtreeDelList", baseform);

   System.out.println(audienceAll.toString());
   System.out.println(StringUtils.join(books,"\",\""));
   System.out.println(books);
   books.remove(new A());
   System.out.println(books);

   books.remove(new A());
   System.out.println(books);

   List<String> list =new ArrayList<String>();
   try {
       for(String temp:list){
           System.out.println("aaaa"+temp);
       }
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }

}
}

/* 移除满足 (o==null ? get(i)==null : o.equals(get(i))) 的最低索引的元素（如果存在此类元素）
。如果列表中包含指定的元素，则返回 true*/
class A{
	public boolean equals(Object object){
		return true;
	}
}
