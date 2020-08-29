package mn.crawler.image_search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

public class Search_Results extends AppCompatActivity {

    private ImageView imageView;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__results);
        imageView =  findViewById(R.id.imageView);
        recyclerView =  findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        ArrayList<ImageUrl> urls = (ArrayList<ImageUrl>) getIntent().getSerializableExtra("list");
        DataAdapter dataAdapter = new DataAdapter(getApplicationContext(), urls);
        recyclerView.setAdapter(dataAdapter);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

