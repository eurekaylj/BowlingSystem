package cn.edu.ncu.bowling.systems;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.List;

public class LoginSys {
    private List<Participants> account;//���������е��˺���Ϣ

    public LoginSys() {
        /*
        �����ǵ�¼ϵͳ������Ҫ�޸����ݿ�����ݣ�Ҳ�Ͳ���ɾ���Ͳ����� --Eureka
         */
        this.account = new JDBC().fillParticipants();
    }
}
