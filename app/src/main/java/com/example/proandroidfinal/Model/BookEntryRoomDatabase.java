package com.example.proandroidfinal.Model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

@Database(entities = {BookEntry.class}, version = 1)
public abstract class BookEntryRoomDatabase extends RoomDatabase {

    public abstract BookEntryDao bookEntryDao();

    private static volatile BookEntryRoomDatabase INSTANCE;

    static BookEntryRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookEntryRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BookEntryRoomDatabase.class, "book_database")
                            .addCallback(sRoomDataBaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDataBaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    new PopulateDBAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDBAsync extends AsyncTask<Void, Void, Void> {
        private final BookEntryDao mDao;

        PopulateDBAsync(BookEntryRoomDatabase db){
            mDao = db.bookEntryDao();
        }

        @Override
        protected void onPreExecute(){
            Log.d("onPreExecute", "PopulateDBAsync");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //mDao.deleteAll();

            //BookEntry book = new BookEntry(0,"Title", "Author", "123456789234", "blah.blah");
            //mDao.insert(book);
            return null;
        }
    }
}
