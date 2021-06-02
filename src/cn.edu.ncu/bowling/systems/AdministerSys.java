package cn.edu.ncu.bowling.systems;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.DAO.Source;
import cn.edu.ncu.bowling.entities.Games;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdministerSys {
    private List<Participants> participantsList;

    private String currentId;
    private static AdministerSys instance;
    private static Source source = new Source(); //方便插入和删除集合

    //这个单例模式你们看看要不要改，要不要先在外面设立两个private的Sys
    public AdministerSys(String inputId) {
        participantsList = new JDBC().fillParticipants(3);
//        participantsList = new source.getParticipantList(); 管理员中我要的是全体成员的集合

        setCurrentId(inputId);
        PlayerSys.getInstance();
        CoachSys.getInstance(inputId);
    }


    public static AdministerSys getInstance(String inputId) {
        if (instance == null)
            instance = new AdministerSys(inputId);
        return instance;
    }


    //修改密码你们自己在继续修改和完善 （狗头）
    /**
     * 修改密码
     * @param currentId
     */
    public void changePassword(String currentId){
        Participants currentPlayer = queryById(currentId);
        var old = currentPlayer.getPassword();
        String inputPassword = "这里结束输入的密码李洛峰 （狗头）";

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
        var administer = new Participants();
        administer.setId(id);
        var index = participantsList.indexOf(administer);
        if(index != -1)
            return participantsList.get(index);
        else{
            System.out.println("傻逼！输错Id了，没这个人");
            return null;//后面的重新输入环节你们自己再调整一下，实在不行默认输入的Id永远正确（狗头）
        }
    }

    /**
     * 显示个人信息
     */
    public void info(){
        queryById(currentId).showInfo();
    }

    public void change(){
        //你们自己加修改个人信息
    }

    /**
     * 删除队员
     * @param participant
     */
    public void removePlayer(Participants participant){
        participantsList.remove(participant);
    }

    /**
     * 方法重载
     * @param id 要删除的队员的Id
     */
    public void removePlayer(String id){
        var participant = new Participants();
        participant.setId(id);
        if(participant.getType() == 3){
            //如果删的是教练，全队都删了；或者你们不考虑这种请况，把这段删了
            for(Participants player:participantsList){
                if(player.getTeamNum() == participant.getTeamNum()){
                    participantsList.remove(participant);
                }
            }
        }else
            participantsList.remove(participant);
    }

    /**
     * 添加队员
     * @param player
     */
    public void addPlayer(Participants player){
        participantsList.add(player);
    }

    /**
     * 方法重载
     * @param id 要增加的队员的Id
     */
    public void addPlayer(String id){
        var participant = new Participants();
        participant.setId(id);
        participantsList.add(participant);
    }


    /**
     * 修改比赛成绩
     * @param date 用来找比赛
     * @param side 修改的那个人
     * @param score 修改后的分数
     */
    public void changeScore(Date date,int side,int score){
        Games game = GameSys.getInstance().findGame(date);
        game.setSideScore(side,score);
    }

    /**
     * 录入成绩
     */
    public void addGame(){
        Games g = new Games(); //Games的构造方法要不就是全空，要不就是参数全满
        GameSys.getInstance().getGamesList().add(g);
    }

    /**
     * 发布消息的函数
     */
    public void notification(){

    }

    /**
     * 显示地图
     */
    public void showMap(){

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
