package cn.edu.ncu.bowling.entities;

import java.util.Objects;

public class Participants {
    private String id;
    private String name;
    private String password;
    private String gender;
    private String age;
    private String address;
    private int teamNum;
    private int type;


    public Participants() {
    }

    public Participants(String name, String id, String password, String gender, String age, String address, int teamNum, int type) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.teamNum = teamNum;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Participants{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", teamNum=" + teamNum +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(id,that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int compareTo(Participants p1,Participants p2) {return id.compareTo(p2.id);}

    public void showInfo() {
        System.out.println("个人信息  " +
                "id:'" + id + '\'' +
                " name:" + name + '\'' +
                " gender: " + gender + '\'' +
                " age: " + age + '\'' +
                " address: " + address + '\'' +
                " teamNum: " + teamNum +
                " type: " + type );
    }
}
