package com.planetinnovative.finalapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataService {
    @GET("php/get.php")
    public Call<List<DataModel>> getNoteData();

    @GET("php/db.php?id=127123123&title=THis+is+title&priority=H&detail=skladjfkldasjfl+kasf&submit=Submit")
    public Call<DataSetModel> setNoteData(@Query("id") int id,
                                             @Query("title") String title,
                                             @Query("priority") String ipriorityd,
                                             @Query("detail") String detail);
}
