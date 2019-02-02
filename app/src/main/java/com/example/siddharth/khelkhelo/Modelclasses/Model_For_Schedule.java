package com.example.siddharth.khelkhelo.Modelclasses;

/**
 * Created by siddharth on 19/5/18.
 */

public class Model_For_Schedule {
    @SuppressWarnings("day")
    private String day;
    @SuppressWarnings("date")
    private String date;
    @SuppressWarnings("time")
    private String time;
    @SuppressWarnings("team1image")
    private String team1image;
    @SuppressWarnings("team1name")
    private String team1name;
    @SuppressWarnings("team2image")
    private String team2image;
    @SuppressWarnings("team2name")
    private String team2name;

    public Model_For_Schedule(String day, String date, String time, String team1image, String team1name, String team2image, String team2name) {
        this.day = day;
        this.date = date;
        this.time = time;
        this.team1image = team1image;
        this.team1name = team1name;
        this.team2image = team2image;
        this.team2name = team2name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeam1image() {
        return team1image;
    }

    public void setTeam1image(String team1image) {
        this.team1image = team1image;
    }

    public String getTeam1name() {
        return team1name;
    }

    public void setTeam1name(String team1name) {
        this.team1name = team1name;
    }

    public String getTeam2image() {
        return team2image;
    }

    public void setTeam2image(String team2image) {
        this.team2image = team2image;
    }

    public String getTeam2name() {
        return team2name;
    }

    public void setTeam2name(String team2name) {
        this.team2name = team2name;
    }
}
