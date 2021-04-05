package javaPractice.simple.xstream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private String personid;
    private String name;
    private String address;
    private String tel;
    private String email;
    private Date date;

}
