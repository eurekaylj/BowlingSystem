package cn.edu.ncu.bowling.systems;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Games;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.List;

public class ScoreSys {

    private static ScoreSys instance ;
    List<Participants> players;

    ScoreSys() {
        players = new JDBC().fillParticipants(3,4);
        new JDBC().deleteParticipants(3,4);
    }

    /**
     * 程序结束前一定要执行这个，把数据放回数据库 --Eureka
     */
    public void updateDataBase() {
        new JDBC().insertParticipants(players);
    }

    static ScoreSys getInstance() {
        if (instance == null)
            instance = new ScoreSys();
        return instance;
    }

    /**
     * 计算积分榜
     */
    public void calculateScoreBoard(){
        List<Games> games = GameSys.getInstance().getGamesList();
        //遍历参赛队员
        for(Participants player:players){
            //获取这个参赛队员参加过的比赛集合
            Games playerGame = GameSys.getInstance().findGame(player.getId());

//            for(Games game:playerGame){
                //获取参赛队员是第几个
                int index = playerGame.getSide().indexOf(Integer.parseInt(player.getId()));
                player.setScore(player.getScore() + playerGame.getSideScore().get(index) );

        }

    }

    /**
     * 显示积分榜
     */
    public void showScoreBoard(){
        System.out.println("姓名              总分");
        for(Participants player:players){
            System.out.println(String.format("%s        %s",player.getName(),player.getScore()));
        }
    }

}
