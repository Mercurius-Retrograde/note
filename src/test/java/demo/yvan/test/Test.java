package demo.yvan.test;

import demo.yvan.utils.DBUtil;

public class Test {
    @org.junit.Test
    public void TestDB(){
        System.out.println(DBUtil.getConnection());
    }
}
