package com.example.siddharth.khelkhelo.Modelclasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Siddharth on 15-May-18.
 */

public class ModelPoint {
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("teams")
    @Expose
    private String teams;
    @SerializedName("play")
    @Expose
    private String play;
    @SerializedName("win")
    @Expose
    private String win;
    @SerializedName("nr")
    @Expose
    private String nr;
    @SerializedName("nrr")
    @Expose
    private String nrr;
    @SerializedName("pts")
    @Expose
    private String pts;

    public ModelPoint(String photo, String teams, String play, String win, String nr, String nrr, String pts) {
        this.photo = photo;
        this.teams = teams;
        this.play = play;
        this.win = win;
        this.nr = nr;
        this.nrr = nrr;
        this.pts = pts;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getNrr() {
        return nrr;
    }

    public void setNrr(String nrr) {
        this.nrr = nrr;
    }

    public String getPts() {
        return pts;
    }

    public void setPts(String pts) {
        this.pts = pts;
    }
}