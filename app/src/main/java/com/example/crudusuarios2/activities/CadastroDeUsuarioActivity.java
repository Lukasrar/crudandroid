package com.example.crudusuarios2.activities;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudusuarios2.R;
import com.example.crudusuarios2.dto.DtoUser;
import com.example.crudusuarios2.services.RetrofitService;

public class CadastroDeUsuarioActivity extends AppCompatActivity {

    private static final String TAG = "CadastroDeUsuarioActiv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_usuario);
    }

    public void cadastrar(View view) {
        String name = ((EditText)findViewById(R.id.et_cadastro_usuario_nome)).getText().toString();
        String email = ((EditText)findViewById(R.id.et_cadastro_uisuario_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.et_cadastro_usuario_senha)).getText().toString();
        String phone = ((EditText)findViewById(R.id.et_cadastro_usuario_telefone)).getText().toString();

        DtoUser dtoUser = new DtoUser(email, name, password, phone);

        RetrofitService.getServico(this).casdastraUsuario(dtoUser).enqueue(new Callback<DtoUser>() {
            @Override
            public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                Toast.makeText(CadastroDeUsuarioActivity.this, "Usuário cadastrado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DtoUser> call, Throwable t) {
                Log.d(TAG,"onFailure: "+t.getMessage());
            }
        });
    }
}
