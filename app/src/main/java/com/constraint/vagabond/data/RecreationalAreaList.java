package com.constraint.vagabond.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.room.Entity;
import androidx.room.TypeConverters;

public final class RecreationalAreaList {

  @SerializedName("RECDATA")
  @Expose
  public List<RecreationalArea> recreationalAreaList;

  public RecreationalAreaList(List<RecreationalArea> recreationalAreaList) {
    this.recreationalAreaList = recreationalAreaList;
  }
}
