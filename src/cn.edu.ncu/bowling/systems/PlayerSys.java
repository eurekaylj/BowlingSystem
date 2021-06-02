package cn.edu.ncu.bowling.systems;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Games;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.ArrayList;
import java.util.List;

public class PlayerSys {
    private List<Participants> playersList;
    private GameSys games;


    private String currentId;
    private static PlayerSys instance = null;

    public PlayerSys(String inputId) {
        playersList = new JDBC().fillParticipants(3,4);
        new JDBC().deleteParticipants(3,4);
        setCurrentId(inputId);
    }

    public static PlayerSys getInstance(String inputId) {
        if (instance == null)
            instance = new PlayerSys(inputId);
        return instance;
    }

    PlayerSys() {
        playersList = playersList = new JDBC().fillParticipants(3,4);
    }
    //这连个不带参数的是为其他系统待用时写的，或者可以把这两个删了，调用有参数的时传个空值
    static PlayerSys getInstance() {
        if (instance == null)
            instance = new PlayerSys();
        return instance;
    }


    /**
     * 修改密码，这是大概的逻辑，李洛峰你自己根据你的输入窗口自己改
     * @param currentId
     */
    public void changePassword(String currentId){
        Participants currentPlayer = queryById(currentId);
        var old = currentPlayer.getPassword();
        String inputPassword = "这里存放输入的密码，李洛峰（狗头）";

        if( old.equals(inputPassword) ){
            var newPassword1 = "请输入新密码：";
            while(true) { //这里我想做成两次输入新密码
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
        Participants player = new Participants();
        player.setId(id);
        var index = playersList.indexOf(player);
        if(index != -1)
            return playersList.get(index);
        else{
            System.out.println("傻逼！输错Id了，没这个人");
            return null;//后面的重新输入环节你们自己再调整一下，实在不行默认输入的Id永远正确（狗头）
        }
    }


    public void getGameInfo(String currentId){
        GameSys gameSys = GameSys.getInstance();
        ArrayList<Games> myGame = gameSys.findGame(currentId);

        if(!myGame.isEmpty()){
            for(Games games:myGame){
                System.out.println(games.toString());
            }
        }else
            System.out.println("没参加比赛");
    }

    //显示个人信息
    public void info(){
        queryById(currentId).showInfo();
    }

    public void change(){
        //修改个人信息
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

    public List<Participants> getPlayersList(){
        return playersList;
    }

}

