package mn.crawler.image_search;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("photos")
    Photos photos;

    @SerializedName("stat")
    String stat;

    public Photos getPhotos() {
        return photos;
    }

    public String getStat() {
        return stat;
    }
}
