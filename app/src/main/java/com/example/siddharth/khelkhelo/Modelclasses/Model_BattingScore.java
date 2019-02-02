package com.example.siddharth.khelkhelo.Modelclasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by siddharth on 8/6/18.
 */

public class Model_BattingScore {
    @SerializedName("player_name")
    @Expose
    private String player_name;
    @SerializedName("run")
    @Expose
    private String run;
    @SerializedName("balls")
    @Expose
    private String balls;
    @SerializedName("fours")
    @Expose
    private String fours;
    @SerializedName("six")
    @Expose
    private String six;
    @SerializedName("sr")
    @Expose
    private String sr;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("date")
    @Expose
    private String date;

    public Model_BattingScore(String player_name, String run, String balls, String fours, String six, String sr, String team, String date) {
        this.player_name = player_name;
        this.run = run;
        this.balls = balls;
        this.fours = fours;
        this.six = six;
        this.sr = sr;
        this.team = team;
        this.date = date;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getBalls() {
        return balls;
    }

    public void setBalls(String balls) {
        this.balls = balls;
    }

    public String getFours() {
        return fours;
    }

    public void setFours(String fours) {
        this.fours = fours;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
