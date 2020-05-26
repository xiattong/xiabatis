package com.xiattong.batis.executor;

import com.xiattong.batis.domain.Blog;

import java.sql.*;

/**
 * 参考org.apache.ibatis.executor.Executor
 */
public class XiaExecutor {
    public <T> T query(String sql, Object... parameter) {
        Connection conn = null;
        Statement stmt = null;
        Blog blog = new Blog();

        try {
            // 注册 JDBC 驱动
            //Class.forName("com.mysql.jdbc.Driver");

            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gp_db?" +
                    "useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", "123456");

            // 执行查询
            stmt = conn.createStatement();
            String sqlformat = String.format(sql,parameter);
            System.out.println("sql:"+sqlformat);
            ResultSet rs = stmt.executeQuery(String.format(sqlformat,parameter));

            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T) blog;
    }
}
