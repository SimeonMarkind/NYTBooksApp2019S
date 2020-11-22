package com.example.proandroidfinal.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.proandroidfinal.R;

import java.util.List;


public class BookEntryListAdapter extends RecyclerView.Adapter<BookEntryListAdapter.BookEntryViewHolder> {

    class BookEntryViewHolder extends RecyclerView.ViewHolder {

        protected TextView vTitle;
        protected TextView vAuthor;
        protected TextView vISBN;
        protected TextView vImageURL;
        protected Button vBtnDelete;

        public BookEntryViewHolder(@NonNull View itemView) {
            super(itemView);

            vTitle = itemView.findViewById(R.id.bookEntryTitleTxt);
            vAuthor = itemView.findViewById(R.id.bookEntryAuthorTxt);
            vISBN = itemView.findViewById(R.id.bookEntryISBN);
            vImageURL = itemView.findViewById(R.id.bookEntryImageURL);
            vBtnDelete = itemView.findViewById(R.id.btnBookEntryDelete);

            vBtnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //create a BookEntry from the current BookEntry
                    BookEntry temp = new BookEntry(vTitle.getText().toString(),
                            vAuthor.getText().toString(),
                            vISBN.getText().toString(),
                            vImageURL.getText().toString());

                    try {
                        mModel.delete(temp);
                        Log.d("DELETION", "deleted entry");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private final LayoutInflater layoutInflater;
    private List<BookEntry> mEntries;
    private BookEntryViewModel mModel;

    public BookEntryListAdapter(Context context, BookEntryViewModel model) {
        layoutInflater = LayoutInflater.from(context);
        this.mModel = model;
    }

    public void setBookEntries(List<BookEntry> entries) {
        mEntries = entries;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BookEntryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = layoutInflater
                .inflate(R.layout.book_entry_item,
                        viewGroup, false);
        return new BookEntryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookEntryViewHolder b, int i) {
        BookEntry bookEntry = mEntries.get(i);

        b.vTitle.setText(bookEntry.getTitle());
        b.vAuthor.setText(bookEntry.getAuthor());
        b.vISBN.setText(bookEntry.getISBN13());
        b.vImageURL.setText(bookEntry.getImageURL());
    }


    @Override
    public int getItemCount() {
        if (mEntries != null) {
            return mEntries.size();
        }
        return 0;
    }

}
