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
import com.example.proandroidfinal.jigs.Book;

import java.util.List;


public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookHolder> {

    private List<Book> resultList;
    private Context mContext;
    private BookEntryViewModel mModel;

    public BookListAdapter(Context mContext, List<Book> resultList, BookEntryViewModel model) {
        this.resultList = resultList;
        this.mContext = mContext;
        this.mModel = model;
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final BookHolder bookHolder, int i) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        Book book = resultList.get(i);

        bookHolder.vTitle.setText(book.getTitle());
        bookHolder.vAuthor.setText(book.getAuthor());
        bookHolder.vISBN.setText(book.getPrimaryIsbn13());
        bookHolder.vByline.setText(book.getBookReviewLink());
        bookHolder.vPublicationDt.setText(book.getPublisher());
        //bookHolder.vReview.setText(book.getBookReviewLink());

        if (book.getDescription().length() > 0) {
            String rev = "Summary: " + book.getDescription();
            bookHolder.vReview.setText(rev);
        }
        try {
            Glide.with(mContext)
                    .load(book.getBookImage())
                    .into(bookHolder.vImage);
        } catch (Exception e) {
            Log.e("GLIDE", e.getMessage());
        }
        String userName = sharedPreferences.getString("USER_NAME", "default");

        if(userName != "default"){
            String btnText = "Add to " + userName + "'s reading list!";
            bookHolder.vButtonAdd.setText(btnText);
        }
        bookHolder.vButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add data to our Room database
                //Intent intent = new Intent();
                if (!TextUtils.isEmpty(bookHolder.vTitle.getText()) && !TextUtils.isEmpty(bookHolder.vAuthor.getText())) {
                    BookEntry bookEntry = new BookEntry(bookHolder.vTitle.getText().toString(),
                            bookHolder.vAuthor.getText().toString(),
                            bookHolder.vISBN.getText().toString(),
                            getImageUrl(bookHolder.vISBN.getText().toString())
                    );
                    mModel.insert(bookEntry);
                    Log.d("INSERTION", "inserted");

                } else {
                    //something else
                }
            }
        });
    }


    @Override
    public BookHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);

        return new BookHolder(itemView);
    }

    public static class BookHolder extends RecyclerView.ViewHolder {

        protected TextView vTitle;
        protected TextView vAuthor;
        protected TextView vISBN;
        protected TextView vReview;
        protected TextView vPublicationDt;
        protected TextView vByline;
        protected TextView vURL;
        protected ImageView vImage;
        protected ScrollView vScrollview;
        protected TextView vPublicationLablel;
        protected Button vButtonAdd;

        public BookHolder(View v) {
            super(v);

            vTitle = v.findViewById(R.id.cardTitle);
            vButtonAdd = v.findViewById(R.id.cardButton);
            vAuthor = v.findViewById(R.id.cardAuthor);
            vISBN = v.findViewById(R.id.cardISBN);
            vImage = v.findViewById(R.id.cardImage);
            vReview = v.findViewById(R.id.cardReview);
            vScrollview = v.findViewById(R.id.cardScrollview);
            vPublicationDt = v.findViewById(R.id.cardPublicationDT);
            vByline = v.findViewById(R.id.cardByline);
            vPublicationLablel = v.findViewById(R.id.cardPublicationLabel);
            vPublicationLablel.setText("Publisher: ");

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

    private String getImageUrl(String ISBN){
        return "https://s1.nyt.com/du/books/images/" + ISBN + ".jpg";
    }
}
