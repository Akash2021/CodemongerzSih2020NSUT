package com.example.ml_vision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Pair;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class FirResult extends AppCompatActivity
{

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir_result);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);
        List<Pair<String, String>> list =new ArrayList<>();
        list.clear();
        list.add(new Pair<>("PARAMETERS", "VALUES"));
        System.out.println(BaseActivity.parameter.size()+"<-size");
        if(BaseActivity.parameter.size()!=0)
        for(int i = 0; i< BaseActivity.parameter.size(); i++)
        {
            list.add(new Pair <> (BaseActivity.parameter.get(i), BaseActivity.pResult.get(i)));
        }
        ImageView selectedImage = findViewById(R.id.selectedImage);
        selectedImage.setImageURI(BaseActivity.imageUri);
        RecyclerViewAdapter adapter =new RecyclerViewAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed()
    {
        super.onResume();
    }
}
