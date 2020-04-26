package com.wsandsby.ekinnew;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wsandsby.ekinnew.model.BasicResponseRetrofit;
import com.wsandsby.ekinnew.retrofit.BaseApiService;
import com.wsandsby.ekinnew.retrofit.UtilsApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditNamaActivity extends AppCompatActivity {

    Button simpan;
    ImageView back;
    EditText edtnamabaru;
    private SharedPreferences sp;
    String namalama, namabaru, nip;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nama_profil);

        back = findViewById(R.id.btnBackEditNama);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        edtnamabaru = findViewById(R.id.edtNamaBaru);

        mApiService = UtilsApi.getAPIService();

        this.sp = this.getSharedPreferences("sp", Context.MODE_PRIVATE);

        namalama = sp.getString("key_nama",null);
        nip = sp.getString("key_nip",null);
       // edtnamalama.setText(namalama);

        simpan = findViewById(R.id.saveGantiNama);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namabaru = edtnamabaru.getText().toString();
                if(namabaru.equals("")){
                    Toast.makeText(getApplicationContext(), "Nama Baru Tidak Boleh Kosong.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
                    Matcher ms = ps.matcher(namabaru);
                    boolean bs = ms.matches();
                    if(bs){
                        SharedPreferences.Editor editor = sp.edit();

                        editor.remove(sp.getString("key_nama",null));
                        editor.putString("key_nama",namabaru);

                        Call<BasicResponseRetrofit> call = mApiService.updatenamapns(nip,namabaru);
                        call.enqueue(new Callback<BasicResponseRetrofit>() {
                            @Override
                            public void onResponse(Call<BasicResponseRetrofit> call, Response<BasicResponseRetrofit> response) {
                                Toast.makeText(getApplicationContext(), "Update Nama Profil Berhasil.", Toast.LENGTH_SHORT).show();
                                finish();
                            }

                            @Override
                            public void onFailure(Call<BasicResponseRetrofit> call, Throwable t) {
                                Log.e("debug", "onFailure: ERROR > " + t.toString());
                            }
                        });
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Nama Harus Alfabet.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
