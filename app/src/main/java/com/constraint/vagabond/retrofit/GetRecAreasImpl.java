package com.constraint.vagabond.retrofit;

import android.util.Log;

import com.constraint.vagabond.data.RecreationalAreaList;
import com.constraint.vagabond.main.MainContract;
import com.constraint.vagabond.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetRecAreasImpl implements MainContract.GetRecAreasInteractor {

   private final String apiKey = "3e842b31-3481-4b92-8512-930d5f4093c4";

  @Override
  public void getRecAreasList(final OnFinishedListener onFinishedListener, String query) {
    GetRecAreasData service = RetrofitInstance.getInstance().create(GetRecAreasData.class);
    Call<RecreationalAreaList> call = service.getRecreationalAreaData(query,true, apiKey);
    Log.d("URL called", call.request().url() + "");
    call.enqueue(
        new Callback<RecreationalAreaList>() {
          @Override
          public void onResponse(
              Call<RecreationalAreaList> call, Response<RecreationalAreaList> response) {
            onFinishedListener.onFinished(response.body());
          }

          @Override
          public void onFailure(Call<RecreationalAreaList> call, Throwable t) {
            onFinishedListener.onFailure(t);
          }
        });
  }
}
