package com.example.siddharth.khelkhelo.Modelclasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by siddharth on 12/6/18.
 */

public class Model_for_Bowling {
    @SerializedName("bowlername")
    @Expose
    private String bowlername;
    @SerializedName("over")
    @Expose
    private String over;
    @SerializedName("madin")
    @Expose
    private String madin;
    @SerializedName("run")
    @Expose
    private String run;
    @SerializedName("wicket")
    @Expose
    private String wicket;
    @SerializedName("er")
    @Expose
    private String er;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("date")
    @Expose
    private String date;

    public Model_for_Bowling(String bowlername, String over, String madin, String run, String wicket, String er, String team, String date) {
        this.bowlername = bowlername;
        this.over = over;
        this.madin = madin;
        this.run = run;
        this.wicket = wicket;
        this.er = er;
        this.team = team;
        this.date = date;
    }

    public String getBowlername() {
        return bowlername;
    }

    public void setBowlername(String bowlername) {
        this.bowlername = bowlername;
    }

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public String getMadin() {
        return madin;
    }

    public void setMadin(String madin) {
        this.madin = madin;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getWicket() {
        return wicket;
    }

    public void setWicket(String wicket) {
        this.wicket = wicket;
    }

    public String getEr() {
        return er;
    }

    public void setEr(String er) {
        this.er = er;
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