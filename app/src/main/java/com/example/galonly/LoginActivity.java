package com.example.galonly;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    TextView register;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.emailEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        login = (Button) findViewById(R.id.loginButton);
        register = (TextView) findViewById(R.id.lupa);
        progressDialog = new ProgressDialog(LoginActivity.this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(registerIntent);
            }
        });

        login.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(login);
                String sEmail = email.getText().toString();
                String sPassword = password.getText().toString();

                CheckLogin(sEmail, sPassword);
            }
        }));


        }

        public void CheckLogin(final String email, final String password){

        if (checkNetworkConnection()) {
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String resp = jsonObject.getString("server_response");
                                if(resp.equals("[{\"status\":\"OK\"}]")){
                                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG).show();

                                    Intent berhasil = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(berhasil);
                                }else {
                                    Toast.makeText(getApplicationContext(), resp, Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError{
                    Map<String, String> params = new HashMap<>();
                    params.put("email", email);
                    params.put("password", password);
                    return params;
                }
            };

            VolleyConnection.getInstance(LoginActivity.this).addToRequestQue(stringRequest);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.cancel();
                }
            }, 2000);
        }else {
            Toast.makeText(getApplicationContext(), "Tidak Ada Koneksi Internet", Toast.LENGTH_LONG).show();
        }

        }

        public boolean checkNetworkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}