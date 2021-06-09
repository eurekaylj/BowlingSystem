package cn.edu.ncu.bowling.entity;

public class announcement {
    private String information;
    private static cn.edu.ncu.bowling.entity.announcement instance = null;
    public static cn.edu.ncu.bowling.entity.announcement getInstance() {
        if (instance == null)
            instance = new announcement();
        return instance;
    }
    public announcement() {
        this.information ="暂无公告";
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
