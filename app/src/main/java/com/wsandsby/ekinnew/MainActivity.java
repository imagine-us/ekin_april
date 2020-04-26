package com.wsandsby.ekinnew;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    ImageView presensi, pekerjaan, pengaduan, tpp, monitoring, agenda;
    ImageView profil;
    TextView txtNip, txtNama;

    String nip,id,nama;
    private SharedPreferences sp;

    private static final String NIP_KEY = "key_nip";
    private static final String ID_KEY = "key_id";
    private static final String NAMA_KEY = "key_nama";
    private static final String PASSWORD_KEY = "key_password";
    private static final String FOTO_KEY = "key_foto";
    private static final String KEEP_LOGIN_KEY = "key_keep_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sp = this.getSharedPreferences("sp", Context.MODE_PRIVATE);
        nip = this.sp.getString("key_nip",null);
        id = this.sp.getString("key_id",null);
        nama = this.sp.getString("key_nama",null);

        txtNip = findViewById(R.id.nipProfil);
        txtNama = findViewById(R.id.namaProfil);

        txtNip.setText(nip);
        txtNama.setText(nama);

        profil = findViewById(R.id.imageProfil);
        Picasso.with(this).load("http://tahutekno.com/ekinrest/foto/"+this.sp.getString
                ("key_foto",null)).placeholder(R.drawable.johndow).into(profil);


        presensi = findViewById(R.id.iconPresensi);
        presensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this,PresensiBaruActivity.class);
//                startActivity(i);
            }
        });

        pekerjaan = findViewById(R.id.iconPekerjaan);
        pekerjaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Fitur belum tersedia", Toast.LENGTH_LONG).show();
//                startActivity(new Intent(MainActivity.this,PekerjaanBaruActivity.class));
            }
        });

        pengaduan = findViewById(R.id.iconPengaduan);
        pengaduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Fitur belum tersedia", Toast.LENGTH_LONG).show();
//                startActivity(new Intent(MainActivity.this,PengaduanActivityBaru.class));
            }
        });


        tpp = findViewById(R.id.iconTpp);
        tpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Fitur belum tersedia", Toast.LENGTH_LONG).show();
                //startActivity(new Intent(MainActivity.this,TppActivity.class));
            }
        });

        monitoring = findViewById(R.id.iconMonitoring);
        monitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,BawahanActivity.class));
                Toast.makeText(MainActivity.this,"Fitur belum tersedia", Toast.LENGTH_LONG).show();
            }
        });

        agenda = findViewById(R.id.iconAgenda);
        agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,AgendaActivity.class));
                 Toast.makeText(MainActivity.this,"Fitur belum tersedia", Toast.LENGTH_LONG).show();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.iconEditProfile);
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.editProfileMenu){
            finish();
          //  startActivity(new Intent(this, EditProfile.class));
        } else if (item.getItemId() == R.id.editPasswordMenu) {
           // startActivity(new Intent(this, GantiPasswordActivity.class));
        } else if(item.getItemId() == R.id.editNamaMenu){
           // startActivity(new Intent(this, GantiNamaActivity.class));
        }else if (item.getItemId() == R.id.logoutMenu) {
           // showDialogLogout();
        }
        return true;
    }


    private void showDialogLogout(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        // set title dialog
        alertDialogBuilder.setTitle("Konfirmasi");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Anda yakin untuk logout?")
                .setIcon(R.drawable.logo)
                .setCancelable(false)
                .setPositiveButton("YA",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        SharedPreferences.Editor editor = sp.edit();
                        editor.remove(NIP_KEY);
                        editor.remove(ID_KEY);
                        editor.remove(NAMA_KEY);
                        editor.remove(PASSWORD_KEY);
                        editor.remove(FOTO_KEY);
                        editor.remove(KEEP_LOGIN_KEY);
                        editor.apply();
                        startActivity(new Intent(MainActivity.this, SplashScreen.class));
                    }
                }).setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }


}
