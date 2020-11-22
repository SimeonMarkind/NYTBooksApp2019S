package com.example.proandroidfinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText mNameEditText;
    private EditText mAuthorEditText;
    private Switch mNightMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mNameEditText = findViewById(R.id.settingsNameEdit);
        setDefault(mNameEditText, "USER_NAME");


        mAuthorEditText = findViewById(R.id.settingsAuthorEdit);
        setDefault(mAuthorEditText, "FAVE_AUTHOR");

        mNightMode = findViewById(R.id.settingsNightMode);
        setDefault(mNightMode, "NIGHT_MODE");

        FloatingActionButton fab = findViewById(R.id.fabSettingsActivity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commit();
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setDefault(EditText editText, String key) {
        String temp = sharedPreferences.getString(key, "default");
        try {
            if (!temp.equals("default"))
                editText.setText(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDefault(Switch object, String key) {
        int nightMode = sharedPreferences.getInt(key, 1);
        object.setChecked(nightMode == 2);
    }

    private void commit() {
        //Save the different settings options into our preference manager
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //check the name EditText
        if (!mNameEditText.getText().toString().equals(""))
            editor.putString("USER_NAME", mNameEditText.getText().toString());
//check favorite author
        if (!mAuthorEditText.getText().toString().equals(""))
            editor.putString("FAVE_AUTHOR", mAuthorEditText.getText().toString());
        //update night mode
        if (mNightMode.isChecked())
            editor.putInt("NIGHT_MODE", AppCompatDelegate.MODE_NIGHT_YES);
        else
            editor.putInt("NIGHT_MODE", AppCompatDelegate.MODE_NIGHT_NO);

        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.menuAddBooks) {
            commit();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.menuSeeReadingList){
            commit();
            Intent intent = new Intent(this, ReadingListActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
