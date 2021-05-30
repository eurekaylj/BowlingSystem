package cn.edu.ncu.bowling.tests;

import cn.edu.ncu.bowling.entities.Participants;
import cn.edu.ncu.bowling.DAO.JDBC;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Participants> list = new JDBC().fillParticipants(3);
        new JDBC().deleteParticipants(3);
        new JDBC().insertParticipants(list);
        System.out.println(list);
        System.out.println(list.size());
    }
}