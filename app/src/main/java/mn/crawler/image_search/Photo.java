package mn.crawler.image_search;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("id")
    String id;

    @SerializedName("owner")
    String owner;

    @SerializedName("secret")
    String secret;

    @SerializedName("server")
    String server;

    @SerializedName("farm")
    int farm;

    @SerializedName("title")
    String title;

    @SerializedName("ispublic")
    int ispublic;

    @SerializedName("isfriend")
    int isfriend;

    @SerializedName("isfamily")
    int isfamily;

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getSecret() {
        return secret;
    }

    public String getServer() {
        return server;
    }

    public int getFarm() {
        return farm;
    }

    public String getTitle() {
        return title;
    }

    public int isIspublic() {
        return ispublic;
    }

    public int isIsfriend() {
        return isfriend;
    }

    public int isIsfamily() {
        return isfamily;
    }
}


