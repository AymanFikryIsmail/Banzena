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
import com.ayman.banzena.helper.FireBaseCallBack;
import com.ayman.banzena.helper.FireBaseHelper;
import com.ayman.banzena.model.pojo.BanzenaPojo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BanzenaAdapter materialAdapter;
    private RecyclerView recyclerView;
    private ArrayList<BanzenaPojo> banzenaPojos;

    private EditText searchTO ;
    private FireBaseHelper fireBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banzenaPojos = new ArrayList<>();
        fireBaseHelper=new FireBaseHelper();
        LinearLayoutManager layoutManager =new LinearLayoutManager(MainActivity.this);
        recyclerView = findViewById(R.id.recycleViewId);
        recyclerView.setLayoutManager(layoutManager);
        fireBaseHelper.retrieveUserBanzenasFromFirebase(new FireBaseCallBack() {
            @Override
            public void getBanzenas(ArrayList<BanzenaPojo> trips) {
                        banzenaPojos.addAll(trips);
                materialAdapter=new BanzenaAdapter(MainActivity.this, banzenaPojos);
                recyclerView.setAdapter(materialAdapter);
            }
        });


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
