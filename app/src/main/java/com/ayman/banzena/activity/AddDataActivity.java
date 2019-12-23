package com.ayman.banzena.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.ayman.banzena.R;
import com.ayman.banzena.databinding.ActivityAddDataBinding;
import com.ayman.banzena.helper.FireBaseHelper;
import com.ayman.banzena.model.pojo.BanzenaDataPojo;
import com.ayman.banzena.model.pojo.BanzenaPojo;

import java.util.Date;

public class AddDataActivity extends AppCompatActivity {

    private ActivityAddDataBinding binding;

    private FireBaseHelper fireBaseHelper;

    private BanzenaDataPojo banzenaDataPojo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_data);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_data);


        binding.setLifecycleOwner(this);
        initView();
        fireBaseHelper=new FireBaseHelper();

    }
    String passdate;
    String passHour;

    String status;
    boolean stands;
    boolean oilShow;
    boolean oiltanks;
    boolean taawnOils;
    boolean specialProducts;
    boolean jaraken;
    boolean specs;

    void initView(){

        binding.currentdatePass.setText("");
        binding.currentHourPass.setText("");

        binding.statusGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.good:
                        status="good";
                        break;
                    case R.id.verygood:
                        status="very good";
                        break;
                    case R.id.excellent:
                        status="excellent";
                        break;
                }
            }
        });

        binding.stands.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.standYes:
                        stands=true;
                        break;
                    case R.id.standNo:
                        stands=false;
                        break;
                }
            }
        });

        binding.oilShow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.oilsShowYes:
                        oilShow=true;
                        break;
                    case R.id.OilsShowNo:
                        oilShow=false;
                        break;
                }
            }
        });

        binding.oiltanks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.oilsTankYes:
                        oiltanks=true;
                        break;
                    case R.id.oilsTankNo:
                        oiltanks=false;
                        break;
                }
            }
        });


        binding.taawnOils.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.taawnOilsYes:
                        taawnOils=true;
                        break;
                    case R.id.taawnOilsNo:
                        taawnOils=false;
                        break;
                }
            }
        });

        binding.specialProducts.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.specialYes:
                        specialProducts=true;
                        break;
                    case R.id.specialNo:
                        specialProducts=false;
                        break;
                }
            }
        });

        binding.jaraken.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.grakenYes:
                        jaraken=true;
                        break;
                    case R.id.grakenNo:
                        jaraken=false;
                        break;
                }
            }
        });



        binding.specs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.specsYes:
                        specs=true;
                        break;
                    case R.id.specsNo:
                        specs=false;
                        break;
                }
            }
        });


        binding.addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passdate = binding.currentdatePass.getText().toString();
                passHour = binding.currentHourPass.getText().toString();
               double  solar= Double.parseDouble(binding.solar.getText().toString());
                double oil80 = Double.parseDouble(binding.oil80.getText().toString());
                double oil92 = Double.parseDouble(binding.oil92.getText().toString());
                double oil95 = Double.parseDouble(binding.oil95.getText().toString());
                String tanksProblem = binding.tanksProblem.getText().toString();
                String addedProducts = binding.addedProducts.getText().toString();
                String problem = binding.problem.getText().toString();
                String notes = binding.notes.getText().toString();

//                banzenaOils = Double.valueOf(binding.banzenaOils.getText().toString());
//                banzenaTanks = Double.valueOf(binding.banzenaTanks.getText().toString());
                Date d = new Date();
                Long date =d.getTime();

                banzenaDataPojo=new BanzenaDataPojo(date, "",  passdate,passHour,solar, oil80 ,
                       oil92 ,  oil95 ,  tanksProblem ,
                        status  ,addedProducts,  stands, oilShow,oiltanks ,taawnOils,specialProducts ,jaraken ,
                         specs,notes);
//                fireBaseHelper.createBanzenaOnFirebase(Banzena);

                Intent i = new Intent(AddDataActivity.this, MainActivity.class);
                startActivity(i);

            }
        });
    }
}
