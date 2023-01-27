package com.unity3d.player;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Backend {

    public void saveGameInfo(String gameInfo){
        Call<Void> call = RetrofitClient.getInstance().getMyApi().saveGame(new GameInfo("YC478", gameInfo));
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public String loadGame(){
        final String[] info = new String[1];
        Call<GameInfo> call = RetrofitClient.getInstance().getMyApi().loadGame("YC478");
        call.enqueue(new Callback<GameInfo>() {
            @Override
            public void onResponse(Call<GameInfo> call, Response<GameInfo> response) {
                switch (response.code()){
                    case 201:
                        GameInfo gameInfo = response.body();
                        info[0] = gameInfo.getGameInfo();
                        break;
                }
            }

            @Override
            public void onFailure(Call<GameInfo> call, Throwable t) {
            }
        });
        return info[0];
    }
}
