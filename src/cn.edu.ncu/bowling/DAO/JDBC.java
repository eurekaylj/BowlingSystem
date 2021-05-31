package cn.edu.ncu.bowling.DAO;

import cn.edu.ncu.bowling.entities.Games;
import cn.edu.ncu.bowling.entities.Participants;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JDBC {

    /**
     * fillParticipants������type1�����ݿ��ȡ��ͬ���͵�Participants���������
     * deleteParticipants������type1�����ݿ�ɾ����ͬ���͵�Participants���������
     * ע�⣬��ʹ��fillParticipants��һ��Ҫʹ��deleteParticipants����Ȼ���insertParticipantsʱ���������ظ���
     * insertParticipants����List<Participants> list���������ݷ������ݿ�
     */

    public List<Participants> fillParticipants() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Participants> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //����sql
            String sql = "select * from participants";
            //��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //ִ��sql
            rs = stmt.executeQuery(sql);
            //�������������װ����װ�ؼ���
            Participants participants = null;
            list = new ArrayList<Participants>();
            while (rs.next()) {
                //��ȡ����
                String name = rs.getString("name");
                String id = rs.getString("id");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String age = rs.getString("age");
                String address = rs.getString("address");
                int teamNum = rs.getInt("teamNum");
                int type = rs.getInt("type");
                int score = rs.getInt("score");
                //�������󣬲���ֵ
                participants = new Participants();
                participants.setName(name);
                participants.setId(id);
                participants.setPassword(password);
                participants.setGender(gender);
                participants.setAge(age);
                participants.setAddress(address);
                participants.setTeamNum(teamNum);
                participants.setType(type);
                //װ�ؼ���
                list.add(participants);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }

    public List<Participants> fillParticipants(int type1) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Participants> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //����sql
            String sql = "select * from participants where type ="+type1;
            //��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //ִ��sql
            rs = stmt.executeQuery(sql);
            //�������������װ����װ�ؼ���
            Participants participants = null;
            list = new ArrayList<Participants>();
            while (rs.next()) {
                //��ȡ����
                String name = rs.getString("name");
                String id = rs.getString("id");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String age = rs.getString("age");
                String address = rs.getString("address");
                int teamNum = rs.getInt("teamNum");
                int type = rs.getInt("type");
                int score = rs.getInt("score");
                //�������󣬲���ֵ
                participants = new Participants();
                participants.setName(name);
                participants.setId(id);
                participants.setPassword(password);
                participants.setGender(gender);
                participants.setAge(age);
                participants.setAddress(address);
                participants.setTeamNum(teamNum);
                participants.setType(type);
                //װ�ؼ���
                list.add(participants);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }

    public List<Participants> fillParticipants(int type1,int type2) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Participants> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //����sql
            String sql = "select * from participants where type = "+type1+" or type = "+type2;
            //��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //ִ��sql
            rs = stmt.executeQuery(sql);
            //�������������װ����װ�ؼ���
            Participants participants = null;
            list = new ArrayList<Participants>();
            while (rs.next()) {
                //��ȡ����
                String name = rs.getString("name");
                String id = rs.getString("id");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String age = rs.getString("age");
                String address = rs.getString("address");
                int teamNum = rs.getInt("teamNum");
                int type = rs.getInt("type");
                int score = rs.getInt("score");
                //�������󣬲���ֵ
                participants = new Participants();
                participants.setName(name);
                participants.setId(id);
                participants.setPassword(password);
                participants.setGender(gender);
                participants.setAge(age);
                participants.setAddress(address);
                participants.setTeamNum(teamNum);
                participants.setType(type);
                //װ�ؼ���
                list.add(participants);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }

    public void deleteParticipants() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            //����sql
            String sql = "delete from participants";
            //��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //ִ��sql
            stmt.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(stmt,conn);
        }
    }

    public void deleteParticipants(int type) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            //����sql
            String sql = "delete from participants where type ="+type;
            //��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //ִ��sql
            stmt.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(stmt,conn);
        }
    }

    public void deleteParticipants(int type1,int type2) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            //����sql
            String sql = "delete from participants where type ="+type1+" or type = "+type2;
            //��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //ִ��sql
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

    /**
     *��Games�Ĳ���
     */

    public List<Games> fillGames() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Games> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //����sql
            String sql = "select * from games";
            //��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //ִ��sql
            rs = stmt.executeQuery(sql);
            //�������������װ����װ�ؼ���
            Games games = null;
            list = new ArrayList<Games>();
            while (rs.next()) {
                //��ȡ����
                int type = rs.getInt("type");
                Date date = rs.getDate("time");
                String position = rs.getString("position");
                boolean statue = rs.getBoolean("statue");
                int partA = rs.getInt("partA");
                int partB = rs.getInt("partB");
                int partC = rs.getInt("partC");
                int scoreA = rs.getInt("scoreA");
                int scoreB = rs.getInt("scoreB");
                int scoreC = rs.getInt("scoreC");
                //�������󣬲���ֵ
                games = new Games();
                games.setType(type);
                games.setTime(date.toString());
                games.setPosition(position);
                games.getSide().add(partA);
                games.getSide().add(partB);
                games.getSide().add(partC);
                games.getSideScore().add(scoreA);
                games.getSideScore().add(scoreB);
                games.getSideScore().add(scoreC);
                games.setStatus(statue);
                //װ�ؼ���
                list.add(games);
            }
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }

    public void deleteGames() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            //����sql
            String sql = "delete from games";
            //��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //ִ��sql
            stmt.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(stmt,conn);
        }
    }

    public void insertGames(List<Games> list) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Games par = null;
        Iterator<Games> it = list.iterator();
        try {
            conn = JDBCUtils.getConnection();
            while (it.hasNext()) {
                par = it.next();
                String sql = "insert into games values(?,?,?,?,?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, par.getType());
                pstmt.setDate(2, (Date) par.getTime());
                pstmt.setString(3, par.getPosition());
                pstmt.setBoolean(4, par.isStatus());
                pstmt.setInt(5, par.getSide().get(0));
                pstmt.setInt(6, par.getSide().get(1));
                pstmt.setInt(7, par.getSide().get(2));
                pstmt.setInt(8, par.getSideScore().get(0));
                pstmt.setInt(9, par.getSideScore().get(1));
                pstmt.setInt(10, par.getSideScore().get(2));
                pstmt.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

}
