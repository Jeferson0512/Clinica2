package com.tecsup.jeferson.clinica.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tecsup.jeferson.clinica.R;
import com.tecsup.jeferson.clinica.Service.ApiService;
import com.tecsup.jeferson.clinica.Service.ApiServiceGenerator;
import com.tecsup.jeferson.clinica.Service.ResponseMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText username_login,password_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        username_login = (EditText)findViewById(R.id.username_login);
        password_login = (EditText)findViewById(R.id.password_login);

        final String email = sharedPreferences.getString("email", null);
        if(email != null){
            username_login.setText(email);
            password_login.requestFocus();
        }

        // islogged remember
        if(sharedPreferences.getBoolean("islogged", false)){
            // Go to Dashboard
            goDashboard();
        }
    }

    public void Ingresar(View view){
        final String username = username_login.getText().toString();
        String password = password_login.getText().toString();

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Campos obligatorios: username y password", Toast.LENGTH_SHORT).show();
        }

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<ResponseMessage> call = null;
        call = service.loginUsuario(username,password);

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {
                        ResponseMessage responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);
                        Toast.makeText(LoginActivity.this, "Bienvenido "+username, Toast.LENGTH_LONG).show();

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        boolean success = editor
                                .putString("email", username)
                                .putBoolean("islogged", true)
                                .commit();

                        goDashboard();

                    } else {

                        Log.e(TAG, "onError: " + response.errorBody().string());
                        Toast.makeText(LoginActivity.this, "Correo o contraseña incorrectos!", Toast.LENGTH_SHORT).show();

                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }

    public void Registrar(View view){
        Intent intent = new Intent(LoginActivity.this, UserRegistroActivity.class);
        startActivity(intent);
    }

    private void goDashboard() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("correo",username_login.getText().toString());
        startActivity(intent);
        finish();
    }
}
