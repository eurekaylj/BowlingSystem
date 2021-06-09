package cn.edu.ncu.bowling.controller;

import cn.edu.ncu.bowling.entity.announcement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerAction {
    announcement inform=announcement.getInstance();
    @FXML
    private TextField announce;
    @FXML
    private AnchorPane abc;
    @FXML
    private ImageView touxiang;
    MediaPlayer[] mp=new MediaPlayer[1];
    @FXML
    private ChoiceBox rank;
    @FXML
    private CheckBox music;
    @FXML
    private StackPane mainContainer;
    public void initialize() {
        announce.setText(inform.getInformation());
        String[] s =new String[]{"systemMusic.mp3"};
        mp[0]=new MediaPlayer(new Media(getClass().getResource(s[0]).toString()));
        mp[0].play();
        rank.getItems().addAll("总积分榜","组积分榜","本组积分榜");
        rank.getSelectionModel().select(0);
        rank.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener< Number >() {
            @Override
            public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                System.out.println(rank.getItems().get((int)newValue));
            }
        });
        music.setSelected(true);
        music.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if(new_val)
                        mp[0].play();
                    else
                        mp[0].pause();
                });
        announce.setEditable(false);
    }
    public void exit(){
        System.exit(0);
    }
    public void getmap() throws Exception{
        Runtime.getRuntime().exec("explorer https://map.baidu.com/@12898120.55,3315255.29,12z");
    }
    public void addGradeAction() throws IOException{
        action("/cn/edu/ncu/bowling/buttonView/addGrade.fxml","成绩录入");
    }
    public void modifyGradeAction() throws IOException {
        action("/cn/edu/ncu/bowling/buttonView/modifyGrade.fxml","成绩修改");
    }
    public void modifyPasswordAction() throws IOException {
        action("/cn/edu/ncu/bowling/buttonView/modifyPassword.fxml","密码修改");
    }
    public void action(String resourse,String title) throws IOException {
        var stage = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource(resourse));
        var scene = new Scene(root,490,357);
        stage.getIcons().add(new Image("cn/edu/ncu/bowling/NCU.png"));
        stage.setTitle(title);
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void setAnnouncement(){
        inform.setInformation(showInputDialog("提示","请输入要发布的公告："));
        announce.setText(inform.getInformation());
    }
    public String showInputDialog(String title,String content){
        var inputDialog = new TextInputDialog();
        inputDialog.setTitle(title);
        inputDialog.setHeaderText("发布公告");
        inputDialog.setContentText(content);
        return inputDialog.showAndWait().get();
    }
}
