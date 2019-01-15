package com.constraint.vagabond.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.constraint.vagabond.R;
import com.constraint.vagabond.data.DataStore;
import com.constraint.vagabond.data.RecreationalAreaList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsActivity extends AppCompatActivity implements DetailsContract {

  private CollapsingToolbarLayout collapsingToolbarLayout;
  private Toolbar toolbar;
  private FloatingActionButton favButton;
  private String collapsingImageUrl;
  private TextView areaDescription;
  private RecreationalAreaList detailedArea = DataStore.getRecreationalAreaList();
  private List<String> imageUrls;
  private int position;
  private RecyclerView areaImages;
  private Button directionBtn;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent getData = getIntent();
    collapsingImageUrl = getData.getStringExtra("image_url");
    position = getData.getIntExtra("position", 0);
    imageUrls = detailedArea.recreationalAreaList.get(position).getImageUrls();
    initializeView();
  }

  @Override
  protected void onStart() {
    super.onStart();
    initializeData();
    loadImage();
    setDataToRecyclerView();
  }

  @Override
  public void initializeView() {
    setContentView(R.layout.activity_detail);
    toolbar = findViewById(R.id.toolbar_title);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    collapsingToolbarLayout = findViewById(R.id.collapsing_layout);
    areaDescription = findViewById(R.id.description);
    favButton = findViewById(R.id.fav_button);
    areaImages = findViewById(R.id.horizontal_recycler_view);
    areaDescription = findViewById(R.id.description);
    directionBtn = findViewById(R.id.directions);
  }

  public void loadImage() {
    final ImageView expandingImage = findViewById(R.id.collapsing_image);
    Picasso.get().load(collapsingImageUrl).fit().centerCrop().into(expandingImage);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflator = getMenuInflater();
    inflator.inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public void destroyView() {}

  @Override
  public void initializeData() {
    collapsingToolbarLayout.setTitle(detailedArea.recreationalAreaList.get(position).recAreaName);
    String desc = detailedArea.recreationalAreaList.get(position).recAreaDescription;
    areaDescription.setText(desc);
  }

  @Override
  public void setDataToRecyclerView() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    areaImages.setLayoutManager(linearLayoutManager);
    DetailsPhotosAdapter detailsPhotosAdapter = new DetailsPhotosAdapter(imageUrls);
    areaImages.setAdapter(detailsPhotosAdapter);
  }
}
