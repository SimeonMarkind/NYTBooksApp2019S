package com.example.proandroidfinal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proandroidfinal.Model.BookEntry;
import com.example.proandroidfinal.Model.BookEntryViewModel;
import com.example.proandroidfinal.jigs.Result;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {

    private List<Result> resultList;
    private Context mContext;
    private BookEntryViewModel mModel;

    public ReviewAdapter(Context mContext, List<Result> resultList, BookEntryViewModel mModel) {
        this.resultList = resultList;
        this.mContext = mContext;
        this.mModel = mModel;
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final ReviewHolder reviewHolder, int i) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        Result result = resultList.get(i);

        reviewHolder.vTitle.setText(result.getBookTitle());
        reviewHolder.vAuthor.setText(result.getBookAuthor());
        reviewHolder.vISBN.setText(result.getIsbn13().get(0));
        reviewHolder.vByline.setText(result.getByline());
        reviewHolder.vPublicationDt.setText(result.getPublicationDt());

        String userName = sharedPreferences.getString("USER_NAME", "default");

        if(userName != "default"){
            String btnText = "Add to " + userName + "'s reading list!";
            reviewHolder.vCardButton.setText(btnText);
        }

        reviewHolder.vCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add data to our Room database
                //Intent intent = new Intent();
                if (!TextUtils.isEmpty(reviewHolder.vTitle.getText()) && !TextUtils.isEmpty(reviewHolder.vAuthor.getText())) {
                    BookEntry bookEntry = new BookEntry(reviewHolder.vTitle.getText().toString(),
                            reviewHolder.vAuthor.getText().toString(),
                            reviewHolder.vISBN.getText().toString(),
                            getImageURL(reviewHolder.vISBN.getText().toString())
                    );
                    mModel.insert(bookEntry);
                    Log.d("INSERTION", "inserted");

                } else {
                //something else
                }
            }
        });

        if (result.getSummary().length() > 0) {
            String rev = "Summary: " + result.getSummary();
            reviewHolder.vReview.setText(rev);
        }

        try {
            Glide.with(mContext)
                    .load(getImageURL(result.getIsbn13().get(0)))
                    .into(reviewHolder.vImage);
        } catch (Exception e) {
            Log.e("GLIDE", e.getMessage());
        }
    }


    @Override
    public ReviewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);

        return new ReviewHolder(itemView);
    }

    public static class ReviewHolder extends RecyclerView.ViewHolder {

        protected TextView vTitle;
        protected TextView vAuthor;
        protected TextView vISBN;
        protected TextView vReview;
        protected TextView vPublicationDt;
        protected TextView vByline;
        //protected TextView vURL;
        protected ImageView vImage;
        protected ScrollView vScrollview;
        protected Button vCardButton;
        protected BookEntryViewModel mModel;

        public ReviewHolder(View v) {
            super(v);

            vTitle = v.findViewById(R.id.cardTitle);
            vAuthor = v.findViewById(R.id.cardAuthor);
            vISBN = v.findViewById(R.id.cardISBN);
            vImage = v.findViewById(R.id.cardImage);
            vReview = v.findViewById(R.id.cardReview);
            vScrollview = v.findViewById(R.id.cardScrollview);
            vPublicationDt = v.findViewById(R.id.cardPublicationDT);
            vByline = v.findViewById(R.id.cardByline);
            vCardButton = v.findViewById(R.id.cardButton);

            vReview.setMovementMethod(new ScrollingMovementMethod());

            vScrollview.setSmoothScrollingEnabled(true);
            vScrollview.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    vReview.getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
            });

            vReview.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    vReview.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });

            vReview.setMovementMethod(new ScrollingMovementMethod());

        }
    }

    public String getImageURL(String isbn) {

        String url = "https://covers.openlibrary.org/b/isbn/" + isbn + "-L.jpg";
        return url;
    }

}
