package javaPractice.simple.listFile;

import com.common.utils.BeanCopyUtils;
import com.example.vo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
* @author  作者 E-mail:
* @date 创建时间：2017年12月11日 下午4:08:40
* @version 1.0
* @parameter
* @since
* @return  */
public class ListTest {
    public static void main(String[]args){
        try {
            User user =new User();
            user.setAge(12);
            User userVo =new User();
            BeanUtils.copyProperties(userVo,user);
            System.out.println("aa:"+userVo);
            List<User> userList = new ArrayList<>();
            userList.add(user);
            List<User> userNewList = new ArrayList<>();
            BeanCopyUtils.copyPropertyList(userList,userNewList);
            for(User tem : userNewList){
                System.out.println(tem);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
       List<String> books=new ArrayList<>();
       books.add("aaa");
       books.add("bbbb");
       books.add("ccccc");
       System.out.println(books);
       List<String> targetList = new ArrayList<>();
       BeanCopyUtils.copyPropertyList(books,targetList);

       for(Object tem : targetList){
         System.out.println("aaaa"+tem);
       }

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
//class A{
////	public boolean equals(Object object){
////		return true;
////	}
////}
