package javaPractice.simple.enumTest;

import io.swagger.annotations.Api;

@Api(value="枚举类测试")
public class EnumTest {
    public static void main(String[] args) {
        /*枚举类遍历*/
        for(SeasonEnum s : SeasonEnum.values()){
            System.out.println(s+":"+ s.name());
        }
        /**通过Enum的valueOf方法来获取指定枚举类的枚举值*/
        SwitchStatus switchStatus = Enum.valueOf(SwitchStatus.class,"DISABLED");
        System.out.println(switchStatus.name()+":"+switchStatus.getValue());
    }
}
