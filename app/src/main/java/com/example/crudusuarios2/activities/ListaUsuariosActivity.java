package com.example.crudusuarios2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.crudusuarios2.R;
import com.example.crudusuarios2.dto.DtoLogin;
import com.example.crudusuarios2.dto.DtoUser;
import com.example.crudusuarios2.helpers.UserAdapter;
import com.example.crudusuarios2.services.RetrofitService;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuariosActivity extends AppCompatActivity {

    List<DtoUser> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        SharedPreferences sharedPreferences = getSharedPreferences("dados", 0);
        String token = sharedPreferences.getString("token", null);
        RetrofitService.getServico(this).todosUsuarios("Bearer "+token).enqueue(new Callback<List<DtoUser>>() {
            @Override
            public void onResponse(Call<List<DtoUser>> call, Response<List<DtoUser>> response) {
                RecyclerView recyclerView = findViewById(R.id.rv_users);
                recyclerView.setAdapter(new UserAdapter(ListaUsuariosActivity.this, response.body()));
                recyclerView.setLayoutManager(new LinearLayoutManager(ListaUsuariosActivity.this));
            }

            @Override
            public void onFailure(Call<List<DtoUser>> call, Throwable t) {

            }
        });
    }
}
