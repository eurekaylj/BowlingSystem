package cn.edu.ncu.bowling.tests;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Participants> list = new JDBC().fillParticipants();
        System.out.println(list);
        System.out.println(list.size());


    }
}