package com.example.sepen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sepen.api.ApiClient;
import com.example.sepen.api.ApiInterface;
import com.example.sepen.main.MainActivity;
import com.example.sepen.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class login_user extends AppCompatActivity {

    EditText username, password;
    Button login;
    ProgressDialog progressDialog;

    String user1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(login_user.this);
                progressDialog.setMessage("Please Wait .....");
                progressDialog.show();
                ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                Call<User> call = apiInterface.loginUser(username.getText().toString(), password.getText().toString());

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.body().getError()!=null){
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),""+response.body().getError(),Toast.LENGTH_SHORT).show();
                        }else {
                            progressDialog.dismiss();
//                            Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(login_user.this, MainActivity.class);
                            user1=username.getText().toString();
                            i.putExtra("",user1);
                            startActivity(i);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),""+t.toString(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
