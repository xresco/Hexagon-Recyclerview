package com.abed.HexagonRecyclerView.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abed.HexagonRecyclerView.R;
import com.abed.HexagonRecyclerView.model.Country;
import com.abed.HexagonRecyclerView.view.misc.SquareImageView;

import java.util.List;


public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CustomViewHolder> {
    private List<Country> countries;
    private ViewHolderClicks clicksListener;

    public CountriesAdapter(List<Country> countries,
                            ViewHolderClicks clicksListener) {
        this.countries = countries;
        this.clicksListener = clicksListener;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new CustomViewHolder(view, clicksListener);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if (countries == null || countries.size() == 0) {
            return;
        }
        holder.setCountry(countries.get(position));

    }

    @Override
    public int getItemCount() {
        if (countries == null) {
            return 0;
        }

        return countries.size();
    }

    public void updateList(List<Country> itemsList) {
        this.countries = itemsList;
        notifyDataSetChanged();
    }

    public void addToList(List<Country> itemsList) {
        this.countries.addAll(itemsList);
        notifyDataSetChanged();
    }

    public void clear() {
        this.countries.clear();
        notifyDataSetChanged();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //        TextView txt_body;
        SquareImageView imageView;
//        ImageView btn_img;
        ViewHolderClicks clicksListener;
        Country Country;

        public CustomViewHolder(View view, ViewHolderClicks clicksListener) {
            super(view);
            this.clicksListener = clicksListener;
            imageView = (SquareImageView) view.findViewById(R.id.img_view);
//            btn_img = (ImageView) view.findViewById(R.id.btn_img);
            imageView.setOnClickListener(this);
//            btn_img.setOnTouchListener(new View.OnTouchListener() {
//
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//
//                    System.out.println(event.getAction());
//                    if (event.getAction() == MotionEvent.ACTION_UP) {
//                        System.out.println("up ");
//                        //CIRCLE :      (x-a)^2 + (y-b)^2 = r^2
//                        float centerX, centerY, touchX, touchY, radius;
//                        centerX = v.getWidth() / 2;
//                        centerY = v.getHeight() / 2;
//                        touchX = event.getX();
//                        touchY = event.getY();
//                        radius = centerX;
//                        onClick(v);
////                    System.out.println("centerX = "+centerX+", centerY = "+centerY);
////                    System.out.println("touchX = "+touchX+", touchY = "+touchY);
////                    System.out.println("radius = "+radius);
//                        if (Math.pow(touchX - centerX, 2)
//                                + Math.pow(touchY - centerY, 2) < Math.pow(radius, 2)) {
//                            System.out.println("Inside Circle");
//                            return true;
//                        } else {
//                            System.out.println("Outside Circle");
//                            return false;
//                        }
//                    }
//                    return false;
//                }
//
//            });
        }


        public void setCountry(Country Country) {
            this.Country = Country;
//            txt_body.setText(Country.getName());
        }

        @Override
        public void onClick(View v) {
            if (clicksListener != null)
                this.clicksListener.onStorySelected(v, getLayoutPosition(), Country);
        }
    }


    public interface ViewHolderClicks {
        void onStorySelected(View view, int position, Country Country);
    }
}
