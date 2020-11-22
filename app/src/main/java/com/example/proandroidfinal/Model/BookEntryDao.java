package com.example.proandroidfinal.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BookEntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BookEntry bookEntry);

    @Query("DELETE FROM book_table")
    void deleteAll();

    @Query("SELECT * FROM book_table ORDER BY title, author ASC")
    LiveData<List<BookEntry>> getAllEntries();

    @Update
    void updateBookEntry(BookEntry bookEntry);

    @Delete
    void delete(BookEntry bookEntry);
}
