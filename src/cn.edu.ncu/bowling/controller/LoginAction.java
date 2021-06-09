package cn.edu.ncu.bowling.controller;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Participants;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LoginAction {
    @FXML
    private ImageView imView;
    @FXML
    private CheckBox Show;
    @FXML
    private TextField idTxt;
    @FXML
    private PasswordField passwordTxt;
    @FXML
    private ChoiceBox le;
    private List<Participants> account = new JDBC().fillParticipants();//这里获得所有的账号信息
    public String getId() {
        if(idTxt!=null) {
            var id = idTxt.getText();
            return id;
        }
        return null;
    }
    public String getPassword() {
        var password = passwordTxt.getText();
        return password;
    }
    @FXML
    public void initialize() {
        //imView.setImage(new Image("cn/edu/ncu/bowling/loginBackground.jpeg"));

        le.getItems().addAll("请选择你的身份","团队赛运动员","个人赛运动员","团队赛教练","管理员");
        le.getSelectionModel().select(0);
    }
    public void login() throws IOException {
        var stage = new Stage();
        String str = "/cn/edu/ncu/bowling/view/";
        if(Login()&&le.getValue().equals("管理员"))
            str+="manager.fxml";
        else if(Login()&&le.getValue().equals("团队赛教练"))
            str+="coach.fxml";
        else if(Login()&&le.getValue().equals("团队赛运动员"))
            str+="member.fxml";
        else if(Login()&&le.getValue().equals("个人赛运动员"))
            str+="member.fxml";
        else{
            var dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("警告");
            dialog.setContentText("账号、密码或身份错误！");
            dialog.showAndWait();
            return;
        }
        AnchorPane root = FXMLLoader.load(getClass().getResource(str));
        var scene = new Scene(root,886,500);
        stage.getIcons().add(new Image("cn/edu/ncu/bowling/NCU.png"));
        stage.setResizable(false);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        EventHandler<ActionEvent> eventHandler = e -> {
            stage.setTitle("保龄球系统 打个球球小组  当前时间："+df.format(new Date()));
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        stage.setScene(scene);
        stage.show();
        idTxt.clear();
        passwordTxt.clear();
    }
    public Boolean Login() {
        /*
        由于是登录系统，不需要修改数据库的数据，也就不用删除和插入了 --Eureka
         */
        for(Participants participant:account)
            if(participant.getId().equals(idTxt.getText())&&participant.getPassword().equals(getPassword())) {
                return true;
            }
        return false;
    }
}


