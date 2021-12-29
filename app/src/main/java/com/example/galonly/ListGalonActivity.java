package com.example.galonly;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.galonly.Adapter.ListGalonAdapter;
import com.example.galonly.Model.Galon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListGalonActivity extends AppCompatActivity {
    private RecyclerView rvGalon;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galon_list);


        String url = "https://inescantik.herokuapp.com/index";

        rvGalon = (RecyclerView) findViewById(R.id.rv_club);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvGalon.setLayoutManager(llm);

        requestQueue = Volley.newRequestQueue(ListGalonActivity.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("galon");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id", json.getString("id"));
                        map.put("nama_galon", json.getString("nama_galon"));
                        map.put("alamat_galon", json.getString("alamat_galon"));
                        map.put("telepon", json.getString("telepon"));
                        map.put("image", json.getString("image"));
                        list_data.add(map);
                        ListGalonAdapter adapter = new ListGalonAdapter(ListGalonActivity.this, list_data);
                        rvGalon.setAdapter(adapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListGalonActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }


}