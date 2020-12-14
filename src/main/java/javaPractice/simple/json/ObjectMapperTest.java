package javaPractice.simple.json;

import com.example.vo.User_1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
* @author  作者 E-mail:
* @date 创建时间：2019年10月29日 上午10:57:56
* @version 1.0
* @parameter
* @since
* @return  */
public class ObjectMapperTest {
    public static void main(String[]args){
        try {
            Map<String,Object> map = new HashedMap();
            map.put("userId", "111");
            map.put("username", "lqk");
            map.put("password", "123");

            ObjectMapper  objectMapper = new ObjectMapper();
            User_1 user=objectMapper.convertValue(map, User_1.class);
            System.out.println("user"+user.getUserId()+":"
                    +user.getUsername()+":"+user.getPassword());
            System.out.println(objectMapper.writeValueAsString(user));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
