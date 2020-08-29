package mn.crawler.image_search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static String abc = "ManchesterCity";

    private ImageView flickr;
    private EditText search;
    FancyButton btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flickr = findViewById(R.id.flickr);
        search = findViewById(R.id.search);
        btn_go = findViewById(R.id.btn_go);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"One Moment please", Toast.LENGTH_LONG).show();
                String method = "flickr.photos.search";
                String tags = search.getText().toString();
                String api_key = "0b014ac9e14b4f6488e977ef48c5fc47";
                String format = "json";
//        String auth_token = "72157715744830943-21f5da72a60089e8";
//        String api_sig = "492c02a19bafc0efc2ca0a50621f8d0a";
                int nojsoncallback = 1;
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.flickr.com").addConverterFactory(GsonConverterFactory.create()).build();
                Flickr_Api flickr_api = retrofit.create(Flickr_Api.class);
                if(tags=="")
                    tags="error";
                Call<Post> call = flickr_api.getPosts(method, api_key, format, nojsoncallback, tags);

                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {

                        if(response.isSuccessful())
                        {
                            Post posts =  response.body();
                            ArrayList<ImageUrl> urls = new ArrayList<>();
                            for(int i=0;i<posts.getPhotos().getPhoto().size();i++)
                            {
                                String url = "https://farm"+posts.getPhotos().getPhoto().get(i).getFarm()+".static.flickr.com/"+posts.getPhotos().getPhoto().get(i).getServer()+"/"+posts.getPhotos().getPhoto().get(i).getId()+"_"+posts.getPhotos().getPhoto().get(i).getSecret()+".jpg";
                                urls.add(new ImageUrl(url));
                            }
                            Intent intent = new Intent(MainActivity.this,Search_Results.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putSerializable("list", (Serializable) urls);
                            intent.putExtra("list",(Serializable) urls);
                            startActivity(intent);




                        }
                        else{
                            Toast.makeText(MainActivity.this,response.code(),Toast.LENGTH_LONG).show();
                            Log.i("custom",response.code()+"");
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                        Log.i("custom",t.getMessage());
                    }
                });



            }
        });


    }
}