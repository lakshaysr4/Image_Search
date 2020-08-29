package mn.crawler.image_search;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Flickr_Api {

    @GET("/services/rest/")
    Call<Post> getPosts(@Query("method") String method, @Query("api_key") String api_key,
     @Query("format") String format, @Query("nojsoncallback") int nojsoncallback, @Query("text") String text);

}
// @Query("auth_token") String auth_token, @Query("api_sig") String api_sig);
//@Query("tags") String tags,