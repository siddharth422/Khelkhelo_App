package com.example.siddharth.khelkhelo.Home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by siddharth on 29/5/18.
 */

public class Model_for_homescoreboard {
    @SerializedName("matchnumber")
    @Expose
    private String matchnumber;
    @SerializedName("team1name")
    @Expose
    private String team1name;
    @SerializedName("team2name")
    @Expose
    private String team2name;
    @SerializedName("team1image")
    @Expose
    private String team1image;
    @SerializedName("team2image")
    @Expose
    private String team2image;
    @SerializedName("team1run")
    @Expose
    private String team1run;
    @SerializedName("team2run")
    @Expose
    private String team2run;
    @SerializedName("team1rr")
    @Expose
    private String team1rr;
    @SerializedName("team2rr")
    @Expose
    private String team2rr;
    @SerializedName("team1over")
    @Expose
    private String team1over;
    @SerializedName("team2over")
    @Expose
    private String team2over;
    @SerializedName("matchbetween")
    @Expose
    private String matchbetween;
    @SerializedName("series")
    @Expose
    private String series;
    @SerializedName("toss")
    @Expose
    private String toss;
    @SerializedName("motm")
    @Expose
    private String motm;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("stadium")
    @Expose
    private String stadium;
    @SerializedName("umpires")
    @Expose
    private String umpires;
    @SerializedName("referee")
    @Expose
    private String referee;
    @SerializedName("weather")
    @Expose
    private String weather;

    public Model_for_homescoreboard(String matchnumber, String team1name, String team2name, String team1image, String team2image, String team1run, String team2run, String team1rr, String team2rr, String team1over, String team2over, String matchbetween, String series, String toss, String motm, String result, String date, String time, String stadium, String umpires, String referee, String weather) {
        this.matchnumber = matchnumber;
        this.team1name = team1name;
        this.team2name = team2name;
        this.team1image = team1image;
        this.team2image = team2image;
        this.team1run = team1run;
        this.team2run = team2run;
        this.team1rr = team1rr;
        this.team2rr = team2rr;
        this.team1over = team1over;
        this.team2over = team2over;
        this.matchbetween = matchbetween;
        this.series = series;
        this.toss = toss;
        this.motm = motm;
        this.result = result;
        this.date = date;
        this.time = time;
        this.stadium = stadium;
        this.umpires = umpires;
        this.referee = referee;
        this.weather = weather;
    }

    public String getMatchnumber() {
        return matchnumber;
    }

    public void setMatchnumber(String matchnumber) {
        this.matchnumber = matchnumber;
    }

    public String getTeam1name() {
        return team1name;
    }

    public void setTeam1name(String team1name) {
        this.team1name = team1name;
    }

    public String getTeam2name() {
        return team2name;
    }

    public void setTeam2name(String team2name) {
        this.team2name = team2name;
    }

    public String getTeam1image() {
        return team1image;
    }

    public void setTeam1image(String team1image) {
        this.team1image = team1image;
    }

    public String getTeam2image() {
        return team2image;
    }

    public void setTeam2image(String team2image) {
        this.team2image = team2image;
    }

    public String getTeam1run() {
        return team1run;
    }

    public void setTeam1run(String team1run) {
        this.team1run = team1run;
    }

    public String getTeam2run() {
        return team2run;
    }

    public void setTeam2run(String team2run) {
        this.team2run = team2run;
    }

    public String getTeam1rr() {
        return team1rr;
    }

    public void setTeam1rr(String team1rr) {
        this.team1rr = team1rr;
    }

    public String getTeam2rr() {
        return team2rr;
    }

    public void setTeam2rr(String team2rr) {
        this.team2rr = team2rr;
    }

    public String getTeam1over() {
        return team1over;
    }

    public void setTeam1over(String team1over) {
        this.team1over = team1over;
    }

    public String getTeam2over() {
        return team2over;
    }

    public void setTeam2over(String team2over) {
        this.team2over = team2over;
    }

    public String getMatchbetween() {
        return matchbetween;
    }

    public void setMatchbetween(String matchbetween) {
        this.matchbetween = matchbetween;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToss() {
        return toss;
    }

    public void setToss(String toss) {
        this.toss = toss;
    }

    public String getMotm() {
        return motm;
    }

    public void setMotm(String motm) {
        this.motm = motm;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getUmpires() {
        return umpires;
    }

    public void setUmpires(String umpires) {
        this.umpires = umpires;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}