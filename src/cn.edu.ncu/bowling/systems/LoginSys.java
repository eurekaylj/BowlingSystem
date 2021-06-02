package cn.edu.ncu.bowling.systems;

import cn.edu.ncu.bowling.DAO.JDBC;
import cn.edu.ncu.bowling.entities.Participants;

import java.util.List;

public class LoginSys {
    private List<Participants> account;//这里获得所有的账号信息

    public LoginSys() {
        /*
        由于是登录系统，不需要修改数据库的数据，也就不用删除和插入了 --Eureka
         */
        this.account = new JDBC().fillParticipants();
    }
}
