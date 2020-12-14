package javaPractice.simple.jdbc;

import com.common.utils.map.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleTest {
	public static void main(String [] args){
		 Connection connect = null;
//		 PreparedStatement statement = null;
		 PreparedStatement preState = null;
         ResultSet resultSet = null;
		try {
            //第一步：注册驱动
            //第一种方式：类加载(常用)
//            Class.forName("oracle.jdbc.OracleDriver");
            //第二种方式：利用Driver对象
//          Driver driver = new OracleDriver();
//          DriverManager.deregisterDriver(driver);

            //第二步：获取连接
            //第一种方式：利用DriverManager（常用）
//            connect = DriverManager.getConnection("jdbc:oracle:thin:@10.10.68.248:1521:orcl", "riskcontrol", "riskcontrol");
            connect = JdbcUtils.getJdbcConnection();
            //第二种方式：直接使用Driver
//            Properties pro = new Properties();
//            pro.put("user", "你的oracle数据库用户名");
//            pro.put("password", "用户名密码");
//            connect = driver.connect("jdbc:oracle:thin:@localhost:1521:XE", pro);

            //测试connect正确与否
            System.out.println(connect);  

            //第三步：获取执行sql语句对象
            //第一种方式:statement
//            statement = connect.createStatement();

            //第二种方式：PreStatement
            String sql= "select  * from tb1_dept where id = ?";
            preState = connect.prepareStatement(sql);


            //第四步：执行sql语句
            //第一种方式：SMDTV_33
//            resultSet = statement.executeQuery("select  * from RISKINFO_CLAIM where SERIALNO ='26'");
//            resultSet = statement.executeQuery("select  * from SMDTV_33 where DANGERADDERSS  like '%彭南村%'");

            //第二种方式：
//            preState.setInt(1, 2);//1是指sql语句中第一个？,  2是指第一个？的values值
            resultSet = preState.executeQuery();        //执行查询语句
            //查询任何语句，如果有结果集，返回true，没有的话返回false,注意如果是插入一条数据的话，虽然是没有结果集，返回false，但是却能成功的插入一条数据
//            boolean execute = preState.execute();
//            System.out.println(execute);

            //第五步：处理结果集
            while (resultSet.next()){
//                String id = resultSet.getString("CLAIMNAME");
//                String name = resultSet.getString("SERIALNO");
//                String city = resultSet.getString("RISKCNAME");
                String id = resultSet.getString("INSUREDNAME");
                String name = resultSet.getString("POLICYNO");
                String city = resultSet.getString("DANGERADDERSS");
                System.out.println(id+"   "+name+"   "+city);  //打印输出结果集
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	 //第六步：关闭资源
        	JdbcUtils.closeResource(resultSet, preState, connect);
        }
	}
}
