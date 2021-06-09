package cn.edu.ncu.bowling.tests;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Games;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Games> list = new JDBC().fillGames();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(new JDBC().fillParticipants(3,4));

    }
}