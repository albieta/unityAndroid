package com.unity3d.player;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    @POST("shop/user/saveGame")
    Call<Void> saveGame(@Body GameInfo gameInfo);

    @GET("shop/user/loadGame/{idUser}")
    Call<GameInfo> loadGame(@Path("idUser") String idUser);
}
