package mn.crawler.image_search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {
    @SerializedName("page")
    int page;
    @SerializedName("pages")
    int pages;
    @SerializedName("perpage")
    int perpage;

    @SerializedName("total")
    String total;

    @SerializedName("photo")
    List<Photo> photo =null;

    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public String getTotal() {
        return total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }
}
