package cn.edu.ncu.bowling.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class test {
    private final StringProperty name;
    private final StringProperty time;
    private final StringProperty location;
    private final StringProperty team;

    public test(String name, String time, String location, String team) {
        this.name = new SimpleStringProperty(name);
        this.time = new SimpleStringProperty(time);
        this.location = new SimpleStringProperty(location);
        this.team = new SimpleStringProperty(team);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getTeam() {
        return team.get();
    }

    public StringProperty teamProperty() {
        return team;
    }

    public void setTeam(String team) {
        this.team.set(team);
    }
}
