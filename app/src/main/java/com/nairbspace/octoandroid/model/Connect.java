package com.nairbspace.octoandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Connect {

    @SerializedName("command")
    @Expose
    private String command;
    @SerializedName("port")
    @Expose
    private String port;
    @SerializedName("baudrate")
    @Expose
    private Integer baudrate;
    @SerializedName("printerProfile")
    @Expose
    private String printerProfile;
    @SerializedName("save")
    @Expose
    private Boolean save;
    @SerializedName("autoconnect")
    @Expose
    private Boolean autoconnect;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Integer getBaudrate() {
        return baudrate;
    }

    public void setBaudrate(Integer baudrate) {
        this.baudrate = baudrate;
    }

    public String getPrinterProfile() {
        return printerProfile;
    }

    public void setPrinterProfile(String printerProfile) {
        this.printerProfile = printerProfile;
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    public Boolean getAutoconnect() {
        return autoconnect;
    }

    public void setAutoconnect(Boolean autoconnect) {
        this.autoconnect = autoconnect;
    }
}
