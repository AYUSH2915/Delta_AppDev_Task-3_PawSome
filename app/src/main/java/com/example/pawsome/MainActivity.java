package com.example.pawsome;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;

    private List<items> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        mList = new ArrayList<>();
        fetchData();
    }

    private void fetchData() {

        String url = "https://api.thedogapi.com/v1/breeds";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {



                    for(int i = 0 ; i<response.length() ; i++){
                        String t,r1,r2,r3,r;
                        int k,f,k1,f1,k2,f2,k3,f3;


                        JSONObject jsonObject = response.getJSONObject(i);
                        JSONObject image = jsonObject.getJSONObject("image");

                        String imageUrl=image.getString("url");
                        String name = jsonObject.getString("name");
                        JSONObject height = jsonObject.getJSONObject("height");
                        String h=height.getString("metric");
                        JSONObject weight = jsonObject.getJSONObject("weight");
                        String w= weight.getString("metric");
                        String l = jsonObject.getString("life_span");
                        t = jsonObject.toString();
                        k = t.indexOf("temperament") + 14;
                        f = t.indexOf('"',k+1) ;
                        k1 = t.indexOf("breed_group") + 14;
                        f1 = t.indexOf('"',k1+1) ;
                        k2 = t.indexOf("bred_for") + 11;
                        f2 = t.indexOf('"',k2+1) ;
                        k3 = t.indexOf("origin") + 9;
                        f3 = t.indexOf('"',k3+1) ;
                        r = t.substring(k , f);
                        r1 = t.substring(k1,f1);
                        r2 = t.substring(k2,f2);
                        r3 = t.substring(k3,f3);



                        items post = new items(imageUrl,name,h,w,l,r,r1,r2,r3);
                        mList.add(post);

                    }

                    postadapter adapter = new postadapter(MainActivity.this , mList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } ,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }


}

