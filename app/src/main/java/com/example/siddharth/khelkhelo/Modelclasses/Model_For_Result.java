package com.example.siddharth.khelkhelo.Modelclasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Siddharth on 03-May-18.
 */

public class Model_For_Result {
    @SerializedName("fistteamname")
    @Expose
    private String fistteamname;
    @SerializedName("secondteamname")
    @Expose
    private String secondteamname;
    @SerializedName("runone")
    @Expose
    private String runone;
    @SerializedName("runsecond")
    @Expose
    private String runsecond;
    @SerializedName("wonby")
    @Expose
    private String wonby;
    @SerializedName("description")
    @Expose
    private String description;

    public Model_For_Result(String fistteamname, String secondteamname, String runone, String runsecond, String wonby, String description) {
        this.fistteamname = fistteamname;
        this.secondteamname = secondteamname;
        this.runone = runone;
        this.runsecond = runsecond;
        this.wonby = wonby;
        this.description = description;
    }

    public String getFistteamname() {
        return fistteamname;
    }

    public void setFistteamname(String fistteamname) {
        this.fistteamname = fistteamname;
    }

    public String getSecondteamname() {
        return secondteamname;
    }

    public void setSecondteamname(String secondteamname) {
        this.secondteamname = secondteamname;
    }

    public String getRunone() {
        return runone;
    }

    public void setRunone(String runone) {
        this.runone = runone;
    }

    public String getRunsecond() {
        return runsecond;
    }

    public void setRunsecond(String runsecond) {
        this.runsecond = runsecond;
    }

    public String getWonby() {
        return wonby;
    }

    public void setWonby(String wonby) {
        this.wonby = wonby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
