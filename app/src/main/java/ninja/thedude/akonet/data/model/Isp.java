package ninja.thedude.akonet.data.model;

import com.google.gson.annotations.SerializedName;

import ninja.thedude.akonet.Utils.Consts;

/**
 * Created by thedude61636 on 7/23/17.
 */

public class Isp {


    /**
     * id : 23
     * name : AL SARD FIBER
     * status : 1
     * ping : 81
     * loss : 0
     * time : 2017-07-23 07:16:11
     * logo : sard.png
     * lastup : 7 hours ago
     * lastdown : 2 days ago
     */

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("status")
    private String status;
    @SerializedName("ping")
    private String ping;
    @SerializedName("loss")
    private String loss;
    @SerializedName("time")
    private String time;
    @SerializedName("logo")
    private String logo;
    @SerializedName("lastup")
    private String lastup;
    @SerializedName("lastdown")
    private String lastdown;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPing() {
        return ping;
    }

    public void setPing(String ping) {
        this.ping = ping;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLogo() {
        return Consts.IMAGE_URL + logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLastup() {
        return lastup;
    }

    public void setLastup(String lastup) {
        this.lastup = lastup;
    }

    public String getLastdown() {
        return lastdown;
    }

    public void setLastdown(String lastdown) {
        this.lastdown = lastdown;
    }
}
