package com.constraint.vagabond.main.search;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.constraint.vagabond.R;
import com.constraint.vagabond.data.entities.RecreationalAreaList;
import com.constraint.vagabond.main.search.adapter.RecreationalAreaAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
    implements MainContract.MainView, SearchView.OnQueryTextListener {

  Toolbar toolbar;
  private ProgressBar progressBar;
  private RecyclerView recyclerView;
  private MainContract.presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeToolbarAndRecyclerView();
    initProgressBar();
    presenter = new MainPresenterImpl(this);
  }

  public void initializeToolbarAndRecyclerView() {
    toolbar = findViewById(R.id.main_app_toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitle(R.string.app_name);
    recyclerView = findViewById(R.id.recyclerViewID);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
    recyclerView.setLayoutManager(layoutManager);
  }

  public void initProgressBar() {
    progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
    progressBar.setIndeterminate(true);
    RelativeLayout relativeLayout = new RelativeLayout(this);
    relativeLayout.setGravity(Gravity.CENTER);
    relativeLayout.addView(progressBar);
    RelativeLayout.LayoutParams params =
        new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
    progressBar.setVisibility(View.INVISIBLE);
    this.addContentView(relativeLayout, params);
  }

  @Override
  public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override
  public void setDataToRecyclerView(RecreationalAreaList recAreasList) {
    RecreationalAreaAdapter recreationalAreaAdapter = new RecreationalAreaAdapter(recAreasList);
    recyclerView.setAdapter(recreationalAreaAdapter);
    Log.d(MainActivity.class.getSimpleName(), recAreasList.toString());
  }

  @Override
  public void onResponseFailure(Throwable throwable) {
    Toast.makeText(
            MainActivity.this, "Error fetching data" + throwable.getMessage(), Toast.LENGTH_LONG)
        .show();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    MenuItem menuItem = menu.findItem(R.id.app_bar_search);
    SearchView searchView = (SearchView) menuItem.getActionView();
    searchView.setMaxWidth(android.R.attr.maxWidth);
    searchView.setOnQueryTextListener(this);
    return true;
  }

  @Override
  public boolean onQueryTextSubmit(String s) {
    presenter.onSearch(s, getString(R.string.api_key));
    return false;
  }

  @Override
  public boolean onQueryTextChange(String s) {
    return false;
  }
}
