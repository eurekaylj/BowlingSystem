package cn.edu.ncu.bowling.entity;

import javafx.beans.property.*;

public class rankGrade {
    private StringProperty num;
    private StringProperty name;
    private StringProperty grade;

    public rankGrade(String num, String name, String grade) {
        this.num = new SimpleStringProperty(num);
        this.name = new SimpleStringProperty(name);
        this.grade = new SimpleStringProperty(grade);
    }

    public String getNum() {
        return num.get();
    }

    public StringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set(num);
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

    public String getGrade() {
        return grade.get();
    }

    public StringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }
}
