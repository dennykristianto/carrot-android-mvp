package com.mitrais.carrotmobile.data;

import com.mitrais.carrotmobile.model.Bazaar;
import com.mitrais.carrotmobile.model.Login;
import com.mitrais.carrotmobile.model.User;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiHelper {
    @POST("account/login")
    Observable<Login> getLoginResponse(@Body HashMap<String,String> loginInfo);

    @GET("account/details")
    Observable<User> getUserDetails();

    @GET("api/staffs/bazaars")
    Observable<List<Bazaar>> getBazaars();
}
