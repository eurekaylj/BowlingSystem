package cn.edu.ncu.bowling.jdbc;

import cn.edu.ncu.bowling.entities.Participants;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JDBC {

    public List<Participants> fillParticipants(int type1) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Participants> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from participants where type ="+type1;
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Participants participants = null;
            list = new ArrayList<Participants>();
            while (rs.next()) {
                //获取数据
                String name = rs.getString("name");
                String id = rs.getString("id");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String age = rs.getString("age");
                String address = rs.getString("address");
                int teamNum = rs.getInt("teamNum");
                int type = rs.getInt("type");
                int score = rs.getInt("score");
                //创建对象，并赋值
                participants = new Participants();
                participants.setName(name);
                participants.setId(id);
                participants.setPassword(password);
                participants.setGender(gender);
                participants.setAge(age);
                participants.setAddress(address);
                participants.setTeamNum(teamNum);
                participants.setType(type);
                //装载集合
                list.add(participants);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }

    public void deleteParticipants(int type) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "delete from participants where type ="+type;
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            stmt.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(stmt,conn);
        }
    }

    public void insertParticipants(List<Participants> list) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Participants par = null;
        Iterator<Participants> it = list.iterator();
        try {
            conn = JDBCUtils.getConnection();
            while (it.hasNext()) {
                par = it.next();
                String sql = "insert into participants values(?,?,?,?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, par.getName());
                pstmt.setString(2, par.getId());
                pstmt.setString(3, par.getPassword());
                pstmt.setString(4, par.getGender());
                pstmt.setString(5, par.getAge());
                pstmt.setString(6, par.getAddress());
                pstmt.setInt(7, par.getTeamNum());
                pstmt.setInt(8, par.getType());
                pstmt.setInt(9,par.getScore());
                pstmt.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

}
