package com.ayman.banzena.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.ayman.banzena.R;
import com.ayman.banzena.adapter.BanzenaAdapter;
import com.ayman.banzena.model.pojo.BanzenaPojo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BanzenaAdapter materialAdapter;
    private RecyclerView recyclerView;
    private ArrayList<BanzenaPojo> banzenaPojos;

    private EditText searchTO ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banzenaPojos = new ArrayList<>();
        banzenaPojos.add(new BanzenaPojo("el tawan 1","",0.0,0.0));
        banzenaPojos.add(new BanzenaPojo("el wataneya","",0.0,0.0));
        banzenaPojos.add(new BanzenaPojo("el tawan 3","",0.0,0.0));
        banzenaPojos.add(new BanzenaPojo("el nasr 4","",0.0,0.0));
        banzenaPojos.add(new BanzenaPojo("el petrol 5","",0.0,0.0));
        banzenaPojos.add(new BanzenaPojo("alex ","",0.0,0.0));


        recyclerView = findViewById(R.id.recycleViewId);
        materialAdapter=new BanzenaAdapter(this, banzenaPojos);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(materialAdapter);
        initView();
    }


    void initView(){
        searchTO = findViewById(R.id.searchEditText);

        searchTO.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                materialAdapter.filter(charSequence.toString());
                recyclerView.setAdapter(materialAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {



            }
        });


    }
}
