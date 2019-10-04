package com.example.crudusuarios2.services;

import com.example.crudusuarios2.dto.DtoLogin;
import com.example.crudusuarios2.dto.DtoUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceDeServicos {

    @POST("/users")
    Call<DtoUser> casdastraUsuario(@Body DtoUser dtoUser);

    @POST("/auth/login")
    Call<DtoLogin> login(@Body DtoLogin dtoLogin);
}

