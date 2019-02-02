package com.example.siddharth.khelkhelo.Modelclasses;

/**
 * Created by Siddharth on 10-May-18.
 */

public class Model {
    @SuppressWarnings("photo")
    private String photo;
    @SuppressWarnings("name")
    private String name;
    @SuppressWarnings("team")
    private String team;
    @SuppressWarnings("fromcity")
    private String fromcity;
    @SuppressWarnings("age")
    private String age;
    @SuppressWarnings("dob")
    private String dob;
    @SuppressWarnings("battingstyle")
    private String battingstyle;
    @SuppressWarnings("bowlingstyle")
    private String bowlingstyle;

    public Model(String photo, String name, String team, String fromcity, String age, String dob, String battingstyle, String bowlingstyle) {
        this.photo = photo;
        this.name = name;
        this.team = team;
        this.fromcity = fromcity;
        this.age = age;
        this.dob = dob;
        this.battingstyle = battingstyle;
        this.bowlingstyle = bowlingstyle;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBattingstyle() {
        return battingstyle;
    }

    public void setBattingstyle(String battingstyle) {
        this.battingstyle = battingstyle;
    }

    public String getBowlingstyle() {
        return bowlingstyle;
    }

    public void setBowlingstyle(String bowlingstyle) {
        this.bowlingstyle = bowlingstyle;
    }
}