package cn.edu.ncu.bowling.systems;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.buttonController.modifyPasswordAction;
import cn.edu.ncu.bowling.controller.LoginAction;
import cn.edu.ncu.bowling.entities.Games;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.List;

public class PlayerSys {
    private List<Participants> playersList;
    private GameSys games;
    private String currentId;
    private static PlayerSys instance = null;
    LoginAction L=new LoginAction();
    modifyPasswordAction m=new modifyPasswordAction();

    public PlayerSys(String inputId) {
        playersList = new JDBC().fillParticipants(3,4);
        new JDBC().deleteParticipants(3,4);

        setCurrentId(inputId);
    }

    /**
     * 程序结束前一定要执行这个，把数据放回数据库 --Eureka
     */
    public void updateDataBase() {
        new JDBC().insertParticipants(playersList);
    }

    public static PlayerSys getInstance(String inputId) {
        if (instance == null)
            instance = new PlayerSys(inputId);
        return instance;
    }

    public PlayerSys() {
        playersList = new JDBC().fillParticipants(3,4);
        System.out.print(new JDBC().fillParticipants());  //[]数据库无法导入

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
        if(currentPlayer != null){
            var old = currentPlayer.getPassword();
            String inputPassword = L.getPassword();
            if( old.equals(inputPassword) ){
                var newPassword1 = m.getNewpassword();
                while(true) { //这里我想做成两次输入新密码
                    var newPassword2 = m.getConfirm();
                    if(newPassword1.equals(newPassword2)) {
                        currentPlayer.setPassword(newPassword1);
                        break;
                    }
                    else{
                        //输出两次密码不一致，请重新输入
                        System.out.println("两次密码输入不一致！");
                    }
                }

            }else{
                //输出密码错误;
                System.out.println("旧密码输入错误！");
            }

        }else
            System.out.println("dfsa");
    }


    public Participants queryById(String id){
        Participants player = new Participants();
        player.setId(id);
        var index = playersList.indexOf(player);
        System.out.print(playersList.toString());
        if(index != -1) {
            return playersList.get(index);
        }
        else{
            System.out.println("傻逼！输错Id了，没这个人");
            return null;//后面的重新输入环节你们自己再调整一下，实在不行默认输入的Id永远正确（狗头）
        }
    }


    public void getGameInfo(String currentId){
        GameSys gameSys = GameSys.getInstance();
        Games myGame = gameSys.findGame(currentId);

        if(myGame == null){
            System.out.println(games.toString());
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



    public String getCurrentId() {
        return currentId;
    }

    public void setCurrentId(String id) {
        this.currentId = id;
    }

//    public List<Participants> getPlayersList(){
//        return playersList;
//    }

}

