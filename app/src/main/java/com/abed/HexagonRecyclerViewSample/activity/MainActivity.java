package com.abed.HexagonRecyclerViewSample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.abed.HexagonRecyclerViewSample.R;
import com.abed.HexagonRecyclerViewSample.adapter.ImagesAdapter;
import com.abed.hexagonrecyclerview.view.HexagonRecyclerView;

import java.util.LinkedList;
import java.util.List;

/**
 * The main activity where all the images are listed
 */
public class MainActivity extends AppCompatActivity implements ImagesAdapter.ViewHolderClicks {
    private final String TAG = getClass().getName();

    private List<String> images;
    private ImagesAdapter imagesAdapter;
    private HexagonRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadViews();
    }


    private void loadViews() {
        imagesAdapter = new ImagesAdapter(new LinkedList<String>(), this);
        recyclerView = (HexagonRecyclerView) findViewById(R.id.rvItems);

        images = new LinkedList<>();
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2592.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/31910.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/32128.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/31923.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2574.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/24131.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/23690.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/69316.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/23760.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/37918.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/24346.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2580.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2592.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/31910.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/32128.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/31923.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2574.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/24131.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/23690.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/69316.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/23760.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/37918.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/24346.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2580.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2592.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/31910.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/32128.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/31923.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2574.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/24131.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/23690.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/69316.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/23760.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/37918.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/24346.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2580.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2592.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/31910.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/32128.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/31923.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2574.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/24131.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/23690.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/69316.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/23760.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/37918.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/24346.jpg");
        images.add("https://s3.amazonaws.com/99Covers-Facebook-Covers/watermark/2580.jpg");

        imagesAdapter.updateList(images);
        recyclerView.setAdapter(imagesAdapter);


    }


    @Override
    public void onStorySelected(View view, int position, String image) {
        Toast.makeText(this, position + " ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStorySelected: " + position);
    }
}
