package com.constraint.vagabond.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.constraint.vagabond.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

public class DetailsPhotosAdapter extends RecyclerView.Adapter<DetailsPhotosAdapter.Images> {

  private List<String> imagesUrls;

  public DetailsPhotosAdapter(List<String> imageUrls) {
    this.imagesUrls = imageUrls;
  }

  @NonNull
  @Override
  public Images onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
    View view = layoutInflater.inflate(R.layout.horizontal_images_grid, viewGroup, false);
    return new Images(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Images images, int i) {
    String randomUrl = imagesUrls.get(images.getAdapterPosition());
    Picasso.get().load(randomUrl).fit().centerCrop().into(images.image);
  }

  @Override
  public int getItemCount() {
    return imagesUrls.size();
  }

  class Images extends RecyclerView.ViewHolder {

    final ImageView image;

      Images(@NonNull View itemView) {
      super(itemView);
      image = itemView.findViewById(R.id.more_images);
      imageOnClickListener();
    }

    void imageOnClickListener(){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
  }


}
