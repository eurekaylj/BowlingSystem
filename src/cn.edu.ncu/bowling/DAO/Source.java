package cn.edu.ncu.bowling.DAO;

import cn.edu.ncu.bowling.entities.Games;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.List;

public class Source {
    public static List <Participants> playerList = new JDBC().fillParticipants(3,4);
    public static List <Participants> coachList = new JDBC().fillParticipants(2);
    public static List <Participants> managerList = new JDBC().fillParticipants(1);
    public static List <Games> games = new JDBC().fillGames();

    public static List<Participants> getPlayerList() {
        new JDBC().deleteParticipants(3,4);//删除数据库中的数据
        return playerList;
    }

    public static void setPlayerList(List<Participants> playerList) {
        new JDBC().insertParticipants(playerList);//将数据填入数据库
        Source.playerList = playerList;
    }

    public static List<Participants> getCoachList() {
        new JDBC().deleteParticipants(2);//删除数据库中的数据
        return coachList;
    }

    public static void setCoachList(List<Participants> coachList) {
        new JDBC().insertParticipants(coachList);//将数据填入数据库
        Source.coachList = coachList;
    }

    public static List<Participants> getManager() {
        new JDBC().deleteParticipants(1);//删除数据库中的数据
        return managerList;
    }

    public static void setManager(List<Participants> manager) {
        new JDBC().insertParticipants(manager);//将数据填入数据库
        Source.managerList = manager;
    }

    public static List<Games> getGames() {
        new JDBC().deleteGames();//删除数据库中的数据
        return games;
    }

    public static void setGames(List<Games> games) {
        new JDBC().insertGames(games);//将数据填入数据库
        Source.games = games;
    }

}
