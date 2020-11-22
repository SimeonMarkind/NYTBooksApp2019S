package com.example.proandroidfinal;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.proandroidfinal.Model.BookEntry;
import com.example.proandroidfinal.Model.BookEntryListAdapter;
import com.example.proandroidfinal.Model.BookEntryViewModel;

import java.util.List;

public class ReadingListActivity extends AppCompatActivity {

    private BookEntryViewModel mModel;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//Could do this directly in SettingsActivity, but doing it this way to use SharedPreferences
        AppCompatDelegate.setDefaultNightMode(sharedPreferences.getInt("NIGHT_MODE", AppCompatDelegate.MODE_NIGHT_NO));


        FloatingActionButton fab = findViewById(R.id.readingFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadingListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mModel = ViewModelProviders.of(this).get(BookEntryViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.bookEntryRecyclerView);
        final BookEntryListAdapter bookEntryListAdapter = new BookEntryListAdapter(this, mModel);
        recyclerView.setAdapter(bookEntryListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mModel.getAllEntries().observe(this, new Observer<List<BookEntry>>() {
            @Override
            public void onChanged(@Nullable List<BookEntry> entries) {
                Toast.makeText(ReadingListActivity.this, "There are " + entries.size() + " entries",
                        Toast.LENGTH_SHORT).show();
                bookEntryListAdapter.setBookEntries(entries);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.menuSettings) {
            Intent intent = new Intent(ReadingListActivity.this, SettingsActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.menuExit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
