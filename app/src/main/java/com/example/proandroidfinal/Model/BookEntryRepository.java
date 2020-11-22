package com.example.proandroidfinal.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class BookEntryRepository {

    private BookEntryDao mDao;
    private LiveData<List<BookEntry>> mBookEntries;

    BookEntryRepository(Application application){
        BookEntryRoomDatabase db = BookEntryRoomDatabase.getDatabase(application);
        mDao = db.bookEntryDao();
        mBookEntries = mDao.getAllEntries();
    }

    LiveData<List<BookEntry>> getAllEntries(){
        return mBookEntries;
    }

    public void insert(BookEntry bookEntry){
        new insertAsyncTask(mDao).execute(bookEntry);
    }

    private static class insertAsyncTask extends AsyncTask<BookEntry, Void, Void>{

        private BookEntryDao asyncDao;

        insertAsyncTask(BookEntryDao dao){
            asyncDao = dao;
        }

        @Override
        protected Void doInBackground(final BookEntry... params){
            asyncDao.insert(params[0]);
            return null;
        }
    }

    public void delete(BookEntry bookEntry){ new deleteAsyncTask(mDao).execute(bookEntry);}

    private static class deleteAsyncTask extends AsyncTask<BookEntry, Void, Void>{

        private BookEntryDao asyncDao;

        deleteAsyncTask(BookEntryDao dao){
            asyncDao = dao;
        }

        @Override
        protected Void doInBackground(BookEntry... params) {
            asyncDao.delete(params[0]);
            return null;
        }
    }
}
