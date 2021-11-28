package com.example.galonly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailGalonActivity extends AppCompatActivity {

    public static final String ITEM_EXTRA = "item_extra";
    Button btnPesanann;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_galon);

        ImageView imgGalon = findViewById(R.id.imgGalon);
        TextView tvGalonName = findViewById(R.id.tvGalonName);
        TextView tvGalonDetail = findViewById(R.id.tvGalonDetail);
        TextView tvGalonBukaTutup = findViewById(R.id.tvGalonBukaTutup);
        TextView tvGalonHarga = findViewById(R.id.tvGalonHarga);
        btnPesanann = (Button) findViewById(R.id.btnPesanan);

        btnPesanann.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrasi = new Intent (DetailGalonActivity.this, LoginActivity.class);
                DetailGalonActivity.this.startActivity(registrasi);
                finish();
            }
        });


        Galon club = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (club != null) {
            Glide.with(this)
                    .load(club.getPhoto())
                    .into(imgGalon);
            tvGalonName.setText(club.getName());
            tvGalonDetail.setText(club.getDetail());
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Galon");
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }
    }

    /*@Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }*/
    int quantity=0;
    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }

    private void display(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + quantity);
    }

    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


}
