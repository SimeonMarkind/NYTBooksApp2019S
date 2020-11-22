package com.example.proandroidfinal;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.proandroidfinal.Model.BookEntryViewModel;
import com.example.proandroidfinal.jigs.Book;
import com.example.proandroidfinal.jigs.BuyResponse;
import com.example.proandroidfinal.jigs.ListResponse;
import com.example.proandroidfinal.jigs.ListResult;
import com.example.proandroidfinal.jigs.Result;
import com.example.proandroidfinal.jigs.ReviewResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String NYT_API_KEY = "gyciQZWe5ApnH5oqFqkBA8ftBbpGlQ9b";

    private Button mBtnMain;
    private EditText mAuthorTxt;
    private EditText mTitleTxt;
    private FloatingActionButton mFAB;
    private BookEntryViewModel bookEntryViewModel;
    private SharedPreferences sharedPreferences;

    private Gson gson;
    private RecyclerView recyclerView;
    private LinearLayoutManager llm;
    private Spinner mSpinner;
    private Button mBtnList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        checkSettings();

        //Could do this directly in SettingsActivity, but doing it this way to use SharedPreferences
        AppCompatDelegate.setDefaultNightMode(sharedPreferences.getInt("NIGHT_MODE", AppCompatDelegate.MODE_NIGHT_NO));

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        bookEntryViewModel = ViewModelProviders.of(this).get(BookEntryViewModel.class);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        mBtnMain = findViewById(R.id.btnMain);
        mAuthorTxt = findViewById(R.id.editAuthor);
        mTitleTxt = findViewById(R.id.editTitle);
        mSpinner = findViewById(R.id.spnBookList);
        mBtnList = findViewById(R.id.btnBookList);
        mFAB = findViewById(R.id.bookListfab);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();

        mBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = buildURL();
                try {
                    fetchReviews(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //fetch the book lists and set up the spinner
        try {
            fetchBookList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mBtnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String listURL = buildListURL(encodeListName(mSpinner.getSelectedItem().toString()));
                try {
                    fetchSellerList(listURL);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        ReadingListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private String buildListURL(String str) {
        StringBuilder out = new StringBuilder("https://api.nytimes.com/svc/books/v3/lists/current/");
        out.append(str);
        out.append(".json?api-key=");
        out.append(NYT_API_KEY);

        return out.toString();
    }

    private String buildURL() {
        StringBuilder out = new StringBuilder("https://api.nytimes.com/svc/books/v3/reviews.json?");

        String title = mTitleTxt.getText().toString();
        String author = mAuthorTxt.getText().toString();
        if (!title.equals("")) {
            out.append("title=");
            out.append(title);
            out.append("&");
        }
        if (!author.equals("")) {
            out.append("author=");
            out.append(author);
            out.append("&");
        }

        out.append("api-key=");
        out.append(NYT_API_KEY);

        return out.toString();
    }

    private void fetchReviews(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, onReviewLoaded, onReviewError);

        try {
            MySingleton.getInstance(this).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            Log.e("fetchReview", e.getMessage());
        }
    }

    private void fetchBookList() {
        String url = "https://api.nytimes.com/svc/books/v3/lists/names.json?api-key=";
        url = url + NYT_API_KEY;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, onBookListLoaded, onBookListError);

        try {
            MySingleton.getInstance(this).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            Log.e("fetchBookList", e.getMessage());
        }
    }

    private void fetchSellerList(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, onSellerListLoaded, onSellerListError);

        try {
            MySingleton.getInstance(this).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            Log.e("fetchSellerList", e.getMessage());
        }
    }

    private final Response.Listener<String> onReviewLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            ReviewResponse reviewResponse = gson.fromJson(response, ReviewResponse.class);

            List<Result> results = reviewResponse.getResults();
            ReviewAdapter reviewAdapter = new ReviewAdapter(getApplicationContext(), results, bookEntryViewModel);
            recyclerView.setAdapter(reviewAdapter);
        }
    };

    private final Response.Listener<String> onSellerListLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            BuyResponse buyResponse = gson.fromJson(response, BuyResponse.class);
            List<Book> books = buyResponse.getBuyResult().getBooks();

            BookListAdapter bookListAdapter = new BookListAdapter(getApplicationContext(), books, bookEntryViewModel);
            recyclerView.setAdapter(bookListAdapter);
        }
    };

    private final Response.ErrorListener onReviewError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("REVIEW", error.toString());
            Toast.makeText(MainActivity.this, "Failed to find any books", Toast.LENGTH_SHORT).show();
        }
    };

    private final Response.ErrorListener onSellerListError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("SELLERLIST", error.toString());
            Toast.makeText(MainActivity.this, "Failed to load book list", Toast.LENGTH_SHORT).show();
        }
    };

    private final Response.Listener<String> SonBookListLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            ListResponse listResponse = gson.fromJson(response, ListResponse.class);

            List<ListResult> results = listResponse.getResults();
            List<String> names = new ArrayList<>();

            for (ListResult ls : results) {
                names.add(ls.getListName());
            }

            //create adapter for spinner
            try {
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                        MainActivity.this, android.R.layout.simple_spinner_item, names);

                // Drop down layout style - list view with radio button
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                mSpinner.setAdapter(dataAdapter);
            } catch (Exception e) {
                Log.e("spinner adapter", e.getMessage());
            }
        }
    };

    private final Response.ErrorListener onBookListError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("onBookListError", error.getMessage());
        }
    };

    private String encodeListName(String str) {
        return str.trim().toLowerCase().replace(' ', '-');
    }

    private void checkSettings() {
        boolean settingsShown = sharedPreferences.getBoolean("SETTINGS_SHOWN", false);
        if (!settingsShown) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("SETTINGS_SHOWN", true);
            editor.apply();
            //Start the settings intent
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            finish();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuSettings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.menuExit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
