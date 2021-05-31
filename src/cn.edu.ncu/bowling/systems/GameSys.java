package cn.edu.ncu.bowling.systems;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Games;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameSys {

    private List<Games> gamesList;

    private static GameSys instance = null;

    public GameSys() {
        gamesList = new JDBC().fillGames(); //以后改为从数据库导入
    }

    static GameSys getInstance() {
        if (instance == null)
            instance = new GameSys();
        return instance;
    }

    /**
     * 按照比赛中的队员找比赛，返回他参加过的所有比赛
     * @param id 要找的队员id
     * @return
     */
    public ArrayList<Games> findGame(String id){
        ArrayList<Games> myGames = new ArrayList<Games>();
        for(Games game:gamesList){
            if(game.getSide().contains(Integer.parseInt(id) ) ){
                myGames.add(game);
            }
        }
        return myGames;
    }

    /**
     * 看老师法得赛程安排里，每场比赛时间不同，这个依据时间找比赛
     * @param date
     * @return
     */
    public Games findGame(Date date) {
        for(Games game:gamesList){
            if(game.getTime().equals(date) ) {
                return game;
            }
        }
        return null;
    }

    public List<Games> getGamesList() {
        return gamesList;
    }
}
