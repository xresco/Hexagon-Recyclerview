package com.abed.HexagonRecyclerView.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.abed.HexagonRecyclerView.R;
import com.abed.HexagonRecyclerView.controller.HorizontalOverlapDecorator;
import com.abed.HexagonRecyclerView.model.Country;
import com.abed.HexagonRecyclerView.view.adapter.CountriesAdapter;

import java.util.LinkedList;
import java.util.List;

import rx.Subscription;

/**
 * The main activity where all the countries are listed
 */
public class MainActivity extends AppCompatActivity implements CountriesAdapter.ViewHolderClicks {
    private final String TAG = getClass().getName();

    private Subscription storiesLoadingBusSubscription;
    private List<Country> countries;


    private CountriesAdapter countriesAdapter;
    private RecyclerView recyclerView;
//    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadViews();
//        initRx();
//        API_Utils.loadCountries();
    }

    @Override
    protected void onStart() {
        super.onStart();
        countries = new LinkedList<>();
        for (int i = 0; i <= 100; i++)
            countries.add(new Country("test"));
        countriesAdapter.updateList(countries);
        recyclerView.setAdapter(countriesAdapter);

    }


    private void loadViews() {
        countriesAdapter = new CountriesAdapter(new LinkedList<>(), this);
        recyclerView = (RecyclerView) findViewById(R.id.rvItems);


        int mRowSize = 5;
        int itemsInTwoRows = mRowSize * 2 - 1;
        int itemsCountInSmallRow = mRowSize - 1;
        Log.d("items: ", itemsCountInSmallRow + " _ " + itemsInTwoRows);

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, mRowSize * itemsCountInSmallRow);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ((position % itemsInTwoRows >= 0) && (position % itemsInTwoRows <= itemsCountInSmallRow - 1))
                    return mRowSize;
                return itemsCountInSmallRow;
            }
        });

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new HorizontalOverlapDecorator(mRowSize, 10, 10));
        countries = new LinkedList<>();
        for (int i = 0; i <= 100; i++)
            countries.add(new Country("test"));
        countriesAdapter.updateList(countries);
        recyclerView.setAdapter(countriesAdapter);


    }


    @Override
    public void onStorySelected(View view, int position, Country country) {
//        CountryDetailsActivity.startActivity(this, country);
        Toast.makeText(this, position + " ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStorySelected: " + position);
    }
}
