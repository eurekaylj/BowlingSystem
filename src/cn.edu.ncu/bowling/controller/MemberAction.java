package cn.edu.ncu.bowling.controller;

import cn.edu.ncu.bowling.entity.announcement;
import cn.edu.ncu.bowling.entity.rankGrade;
import cn.edu.ncu.bowling.entity.test;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class MemberAction {
    announcement inform=announcement.getInstance();
    @FXML
    private TextField announce;
    @FXML
    private ImageView touxiang;
    private ObservableList<test> cellDataLeft = FXCollections.observableArrayList();
    private ObservableList<rankGrade>  cellDataRight= FXCollections.observableArrayList();
    MediaPlayer[] mp=new MediaPlayer[1];
    @FXML
    private TableView<test> messageLeft;
    @FXML
    private TableColumn<test,String> testName,
            testTime,testLocation,testTeam;
    @FXML
    private TableView<rankGrade> messageRight;
    @FXML
    private TableColumn<rankGrade,String> rankNum,rankName,rankGrade;
    @FXML
    private ChoiceBox rank;
    @FXML
    private CheckBox music,myTest;
    @FXML
    public void initialize() {
        cellDataLeft.add(new test("1","Jack","wq","wq"));
        cellDataLeft.add(new test("1","Jerry","sda","das"));
        cellDataLeft.add(new test("1","Mike","dsa","d"));
        testName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        testTime.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        testLocation.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        testTeam.setCellValueFactory(cellData -> cellData.getValue().teamProperty());
        messageLeft.setItems(cellDataLeft);

        cellDataRight.add(new rankGrade("1","Jack","wq"));
        cellDataRight.add(new rankGrade("2","Jerry","sda"));
        cellDataRight.add(new rankGrade("3","Mike","dsa"));
        rankNum.setCellValueFactory(cellData -> cellData.getValue().numProperty());
        rankName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        rankGrade.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());
        messageRight.setItems(cellDataRight);

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
                    //System.out.println(gg.selectedProperty().getValue());
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
    public void modifyPasswordAction() throws IOException {
        var m = new ManagerAction();
        m.action("/cn/edu/ncu/bowling/buttonView/modifyPassword.fxml","密码修改");
    }
}
