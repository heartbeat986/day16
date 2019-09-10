package day16;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Data {
    private static DataSource dataSource = null;

    static {
        Properties pro = new Properties();
        InputStream is = Data.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addUser(String name,String password) throws SQLException {
        Connection connect = dataSource.getConnection();
        PreparedStatement smt = (PreparedStatement) connect.createStatement();
        String sql = "insert into user values(?,?)";
        smt.setString(1,name);
        smt.setString(2,password);
        boolean result = smt.execute();
        connect.close();
        smt.close();
        return  result;
    }

    public static boolean checkUser(String name,String password) throws SQLException{
        Connection connect = dataSource.getConnection();
        System.out.printf("查找数据");
        PreparedStatement smt = (PreparedStatement)connect.createStatement();
        String sql = "Select count(*) From User Where name=? and password=?";
        smt.setString(1,name);
        smt.setString(2,password);
        ResultSet set = smt.executeQuery();
        System.out.printf(String.valueOf(set));
        return true;
    }


}
