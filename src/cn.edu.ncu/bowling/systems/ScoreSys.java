package cn.edu.ncu.bowling.systems;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Games;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.ArrayList;
import java.util.List;

public class ScoreSys {

    private static ScoreSys instance = null ;
    List<Participants> players;
    List<Games> games ;

    ScoreSys() {
        players = new JDBC().fillParticipants(3,4);
        games = new JDBC().fillGames();
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

//    /**
//     * 计算积分榜
//     */
//    public void calculateScoreBoard(){
//        List<Games> games = GameSys.getInstance().getGamesList();
//        //遍历参赛队员
//        for(Participants player:players){
//            //获取这个参赛队员参加过的比赛集合
//            if(player.getType() == 3 || player.getType() == 4){
//                Games playerGame = GameSys.getInstance().findGame(player.getId());
//
////            for(Games game:playerGame){
//                //获取参赛队员是第几个
//                int index = playerGame.getSide().indexOf(Integer.parseInt(player.getId()));
//                player.setScore(player.getScore() + playerGame.getSideScore().get(index));
//            }
//
//        }
//
//    }

    /**
     * 显示积分榜
     */


    /**
     * 显示单人赛，Games的type为1表示单人赛
     */
    public void showSingles(){
        List<Games> singleGames = new ArrayList<Games>();
        for(Games game:games){
            if(game.getType() == 1){
                singleGames.add(game);
            }
        }

        singleGames.sort((o1,o2) ->  o1.getSideScore().get(0) - o2.getSideScore().get(1));

        System.out.println("队伍              总分");
        showScoreBoard(singleGames);
    }

    public void showDoubles(){
        List<Games> doubleGames = new ArrayList<Games>();
        for(Games game:games){
            if(game.getType() == 2){
                doubleGames.add(game);
            }
        }

        doubleGames.sort((o1,o2) ->  o1.getSideScore().get(0) - o2.getSideScore().get(1));

        System.out.println("队伍              总分");
        showScoreBoard(doubleGames);

    }

    public void showTriples(){
        List<Games> triplesGames = new ArrayList<Games>();
        for(Games game:games){
            if(game.getType() == 2){
                triplesGames.add(game);
            }
        }

        triplesGames.sort((o1,o2) ->  o1.getSideScore().get(0) - o2.getSideScore().get(1));

        System.out.println("队伍ID              总分");
        showScoreBoard(triplesGames);

    }

    public void showScoreBoard(List<Games> games){

        for(Games game:games){
            System.out.printf("%d        %d%n",game.getSide().get(0),game.getSideScore().get(0));
        }
    }

}
