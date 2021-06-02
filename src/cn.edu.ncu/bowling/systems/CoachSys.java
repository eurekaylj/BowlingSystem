package cn.edu.ncu.bowling.systems;


import cn.edu.ncu.bowling.DAO.Source;
import cn.edu.ncu.bowling.entities.Participants;
import cn.edu.ncu.bowling.DAO.JDBC;

import java.util.ArrayList;
import java.util.List;

public class CoachSys {

    private String currentId;   //登录此系统的id
    private List<Participants> CoachList;   //操作对象，所有Coach
    private List<Participants> PlayerList; //操作对象，所有player
    private static CoachSys instance ;
    private static Source source = new Source(); //方便插入和删除集合


    public CoachSys(String inputId) {
        //从数据库导入
//        CoachList = new JDBC().fillParticipants(1);
//        new JDBC().deleteParticipants(1);
//        PlayerList = new JDBC().fillParticipants(3);
//        new JDBC().deleteParticipants(3); 之前的写法

        CoachList = source.getCoachList();
        PlayerList = source.getPlayerList();

        setCurrentId(inputId);
        PlayerSys.getInstance();
    }

    /**
     * 程序结束前一定要执行这个，把数据放回数据库 --Eureka
     */
    public void updateDataBase() {
//        new JDBC().insertParticipants(CoachList);
//        new JDBC().insertParticipants(PlayerList); 之前的写法

        source.setCoachList(CoachList);
        source.setPlayerList(PlayerList);
    }

    public static CoachSys getInstance(String inputId) {
        if (instance == null)
            instance = new CoachSys(inputId);
        return instance;
    }

    //修改密码你们自己再继续修改和完善 （狗头）
    /**
     * 修改密码
     * @param currentId
     */
    public void changePassword(String currentId){
        Participants currentPlayer = queryById(currentId);
        var old = currentPlayer.getPassword();
        String inputPassword = "这里结束输入的密码，李洛峰（狗头）";

        if( old.equals(inputPassword) ){
            var newPassword1 = "请输入新密码：";
            while(true) {
                var newPassword2 = "这里再次请输入新密码：";;
                if(newPassword1.equals(newPassword2)) {
                    currentPlayer.setPassword(newPassword1);
                    break;
                }
                else{
                    //输出两次密码不一致，请重新输入
                }
            }
        }else{
            //输出密码错误;
        }

    }

    public Participants queryById(String id){
        var coach = new Participants();
        coach.setId(id);
        var index = CoachList.indexOf(coach);
        if(index != -1)
            return PlayerList.get(index);
        else{
            System.out.println("傻逼！输错Id了，没这个人");
            return null;//后面的重新输入环节你们自己再调整一下，实在不行默认输入的Id永远正确（狗头）
        }
    }

    /**
     * 显示分人信息
     */
    public void info(){
        queryById(currentId).showInfo();
    }

    public void change(){
        //你们自己加修改个人信息
    }

    /**
     * 删除队员
     * @param player
     */
    public void removePlayer(Participants player){
        PlayerList.remove(player);
    }

    /**
     * 方法重载
     * @param id 要删除的队员的Id
     */
    public void removePlayer(String id){
        var player = new Participants();
        player.setId(id);
        PlayerList.remove(player);
    }


    /**
     * 添加队员
     * @param player
     */
    public void addPlayer(Participants player){
        CoachList.add(player);
    }

    /**
     * 方法重载
     * @param id 要增加的队员的Id
     */
    public void addPlayer(String id){
        var player = new Participants();
        player.setId(id);
        PlayerList.add(player);
    }

    /**
     * 显示队伍信息
     * @param teamNum
     */
    //到底有没有队伍这个概念
    public void showTeam(int teamNum){
        ArrayList<String> playerId = findPlayer(teamNum);
        for(String id:playerId){
            queryById(id).showInfo();
            PlayerSys.getInstance().getGameInfo(id);
        }

    }

    /**
     * 设置队长
     * @param id 需要设为队长的队员Id
     */
    public void changeCaption(String id) {
        var currentCoach = queryById(currentId);
        var currentTeamNum = currentCoach.getTeamNum();
        var player = queryById(id);

        if(findCaption(currentTeamNum) != null) {
            var oldCaption = findCaption(currentTeamNum);
            oldCaption.setType(3); //3为队员
            player.setType(4);

        }else{
            player.setType(4);
            System.out.println("提示：这个队伍没有队长,现在设好了");
        }
    }

    /**
     * 找队长
     * @param teamNum
     * @return
     */
    private Participants findCaption(int teamNum){

        ArrayList<String> playerId = findPlayer(teamNum);
        for(String id:playerId){
            if(queryById(id).getType() == 4){  //我这里假设type为4的是队长
                return queryById(id);
            }
        }
        return null;
    }

    /**
     * 找本组所有队员
     * @param teamNum
     * @return
     */
    private ArrayList<String> findPlayer(int teamNum){
        ArrayList<String> Players = new ArrayList<>();
        for(Participants player:PlayerList){

            var playerNum = player.getTeamNum();
            if(teamNum == playerNum){
                Players.add(player.getId());
            }
        }
        return Players;
    }

    /**
     * 积分榜
     */
    public void displayScoreBoard(){
        ScoreSys.getInstance().showScoreBoard();
    }

    public String getCurrentId() {
        return currentId;
    }

    public void setCurrentId(String id) {
        this.currentId = id;
    }
}
