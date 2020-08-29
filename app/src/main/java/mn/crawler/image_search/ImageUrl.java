package mn.crawler.image_search;

public class ImageUrl implements java.io.Serializable {
    String imageUrl;
    public ImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
