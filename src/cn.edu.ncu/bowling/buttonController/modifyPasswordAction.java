package cn.edu.ncu.bowling.buttonController;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.controller.LoginAction;
import cn.edu.ncu.bowling.entities.Participants;
import cn.edu.ncu.bowling.systems.PlayerSys;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.util.List;


public class modifyPasswordAction {
    @FXML
    private PasswordField oldpasswordtxt;
    @FXML
    private PasswordField newpasswordtxt;
    @FXML
    private PasswordField confirmtxt;

    public String getOldpassword() {
        var oldPassword=oldpasswordtxt.getText();
        return oldPassword;
    }


    public String getNewpassword() {
        var newPassword=newpasswordtxt.getText();
        return newPassword;
    }

    public String getConfirm() {
        var confirm=confirmtxt.getText();
        return confirm;
    }

    public void modifyPassword() {
        List<Participants> list = new JDBC().fillParticipants();
        //new JDBC().deleteParticipants();
        LoginAction L=new LoginAction();
        PlayerSys PS=new PlayerSys();
        PS.changePassword(L.getId());
        //new JDBC().insertParticipants(list);
    }

}
