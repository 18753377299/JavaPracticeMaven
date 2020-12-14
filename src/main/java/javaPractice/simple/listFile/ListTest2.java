package javaPractice.simple.listFile;

import java.util.ArrayList;
import java.util.List;

/**
* @author  作者 E-mail:
* @date 创建时间：2017年12月11日 下午4:24:59
* @version 1.0
* @parameter
* @since
* @return  */
public class ListTest2 {
public static void main(String[] args){
   String [] books={"aaa","bbb","ccccc"};
   List bookList=new ArrayList();
   for(int i=0;i<books.length;i++){
       bookList.add(books[i]);
   }
   java.util.ListIterator lIterator= bookList.listIterator();
   while(lIterator.hasNext()){
       System.out.println(lIterator.next());
       lIterator.add("===eeeeee===");
   }

   System.out.println("=======反向=======");
   while(lIterator.hasPrevious()){
       System.out.println(lIterator.previous());
   }
   List<Object[]> list = new ArrayList<Object[]>();
   for (char i='A';i<='S';i++){
       Object[] objects = new Object [2];
       objects[0] = String.valueOf(i) ;
       objects[1] = "0";
       list.add(objects);
   }
   System.out.println(list);
   List<Object[]> objectNewList = new ArrayList<Object[]>();
   for (Object[] object  : list ){
       if(object[1]!=null&&!"0".equals(object[1])){
           objectNewList.add(object);
       }
   }
   System.out.println(objectNewList);
}
}
