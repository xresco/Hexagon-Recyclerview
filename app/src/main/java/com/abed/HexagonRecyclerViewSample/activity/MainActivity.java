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
        imagesAdapter = new ImagesAdapter(new LinkedList<>(), this);
        recyclerView = (HexagonRecyclerView) findViewById(R.id.rvItems);

        images = new LinkedList<>();
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/9589ee21-b498-4e80-8d41-7dafe6d95a8a.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/66bd3349-cbe1-4082-af34-72fd3d546391.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/743ea10c-9e38-4dfc-825c-4e556d155aa9.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/825b26f0-d370-4d7d-9176-e90912c2581e.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/eb55eb5b-3f59-4de8-ba23-b999b6ceaa75.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/80cadf99-b6f8-49f5-aeac-4a5c19c00578.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e1e59061-9f16-4111-abf5-2fc5a24d6fdf.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/9589ee21-b498-4e80-8d41-7dafe6d95a8a.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/66bd3349-cbe1-4082-af34-72fd3d546391.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/743ea10c-9e38-4dfc-825c-4e556d155aa9.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/825b26f0-d370-4d7d-9176-e90912c2581e.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/eb55eb5b-3f59-4de8-ba23-b999b6ceaa75.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/80cadf99-b6f8-49f5-aeac-4a5c19c00578.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e1e59061-9f16-4111-abf5-2fc5a24d6fdf.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/9589ee21-b498-4e80-8d41-7dafe6d95a8a.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/66bd3349-cbe1-4082-af34-72fd3d546391.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/743ea10c-9e38-4dfc-825c-4e556d155aa9.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/825b26f0-d370-4d7d-9176-e90912c2581e.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/eb55eb5b-3f59-4de8-ba23-b999b6ceaa75.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/80cadf99-b6f8-49f5-aeac-4a5c19c00578.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e1e59061-9f16-4111-abf5-2fc5a24d6fdf.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/9589ee21-b498-4e80-8d41-7dafe6d95a8a.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/66bd3349-cbe1-4082-af34-72fd3d546391.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/743ea10c-9e38-4dfc-825c-4e556d155aa9.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/825b26f0-d370-4d7d-9176-e90912c2581e.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/eb55eb5b-3f59-4de8-ba23-b999b6ceaa75.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/80cadf99-b6f8-49f5-aeac-4a5c19c00578.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e1e59061-9f16-4111-abf5-2fc5a24d6fdf.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/9589ee21-b498-4e80-8d41-7dafe6d95a8a.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/66bd3349-cbe1-4082-af34-72fd3d546391.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/743ea10c-9e38-4dfc-825c-4e556d155aa9.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/825b26f0-d370-4d7d-9176-e90912c2581e.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/eb55eb5b-3f59-4de8-ba23-b999b6ceaa75.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/80cadf99-b6f8-49f5-aeac-4a5c19c00578.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e1e59061-9f16-4111-abf5-2fc5a24d6fdf.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/9589ee21-b498-4e80-8d41-7dafe6d95a8a.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/66bd3349-cbe1-4082-af34-72fd3d546391.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/743ea10c-9e38-4dfc-825c-4e556d155aa9.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/825b26f0-d370-4d7d-9176-e90912c2581e.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/eb55eb5b-3f59-4de8-ba23-b999b6ceaa75.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/80cadf99-b6f8-49f5-aeac-4a5c19c00578.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e1e59061-9f16-4111-abf5-2fc5a24d6fdf.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/9589ee21-b498-4e80-8d41-7dafe6d95a8a.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/66bd3349-cbe1-4082-af34-72fd3d546391.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/743ea10c-9e38-4dfc-825c-4e556d155aa9.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/825b26f0-d370-4d7d-9176-e90912c2581e.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/eb55eb5b-3f59-4de8-ba23-b999b6ceaa75.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/80cadf99-b6f8-49f5-aeac-4a5c19c00578.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e1e59061-9f16-4111-abf5-2fc5a24d6fdf.jpg?transform=q_75");
        images.add("http://overmind2.mindvalleyacademy.com/api/v1/assets/e0e280a3-bad7-49e3-81de-0563317cfb44.jpg?transform=q_75");
        imagesAdapter.updateList(images);
        recyclerView.setAdapter(imagesAdapter);


    }


    @Override
    public void onStorySelected(View view, int position, String image) {
        Toast.makeText(this, position + " ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStorySelected: " + position);
    }
}
