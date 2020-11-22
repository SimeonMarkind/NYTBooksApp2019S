package com.example.proandroidfinal.Model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class BookEntryViewModel extends AndroidViewModel {

    private BookEntryRepository mRepository;
    private LiveData<List<BookEntry>> mAllEntries;

    public BookEntryViewModel(Application application) {
        super(application);
        mRepository = new BookEntryRepository(application);
        mAllEntries = mRepository.getAllEntries();
    }

    public LiveData<List<BookEntry>> getAllEntries() {
        return mAllEntries;
    }

    public void insert(BookEntry bookEntry) {
        mRepository.insert(bookEntry);
    }

    public void delete(BookEntry bookEntry) {
        mRepository.delete(bookEntry);
    }
}
