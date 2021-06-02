package cn.edu.ncu.bowling.systems;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Games;


import java.util.Date;
import java.util.List;

public class GameSys {
    private List<Games> gamesList; //这个成绩到底怎么算，我现在只是在Participant类中加了个Score属性记录分数
    private static GameSys instance = null;

    public GameSys() {
        gamesList = new JDBC().fillGames();
        new JDBC().deleteParticipants();
    }

    /**
     * 程序结束前一定要执行这个，把数据放回数据库 --Eureka
     */
    public void updateDataBase() {
        new JDBC().insertGames(gamesList);
    }

    public static GameSys getInstance() {
        if (instance == null)
            instance = new GameSys();
        return instance;
    }

    /**
     * 按照比赛中的队员找比赛，返回他参加过的所有比赛
     *
     * @param id 要找的队员id
     * @return
     */
    public Games findGame(String id) {
        for (Games game : gamesList) {
            if (game.getSide().contains(Integer.parseInt(id))) {
                return game;
            }
        }
        return null;
    }

    /**
     * 方法重载。看老师法得赛程安排里，每场比赛时间不同，这个依据时间找比赛
     *
     * @param date
     * @return
     */
    public Games findGame(Date date) {
        for (Games game : gamesList) {
            if (game.getTime().equals(date)) {
                return game;
            }
        }
        return null;
    }

    public List<Games> getGamesList() {
        return gamesList;
    }
}
