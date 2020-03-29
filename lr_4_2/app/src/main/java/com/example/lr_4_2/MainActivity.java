package com.example.lr_4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ControlActivityList.OnFragmentInteractionListener {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fragment,new ControlActivityList(),"frag1")
                .commit();
    }

    @Override
    public void onFragmentInteraction(String result) {

        //Создаем переменную для дальнейшей передачи ссылки
        String temp="error";

        //Проводим проверку на поступающие данные и передаем ссылку дальше
        if(result=="Google"){
            temp = "https://www.google.com/webhp?client=firefox-b-d";
        }
        else if(result=="Facebook"){
            temp = "https://uk-ua.facebook.com/";
        }
        else if(result=="Twitter"){
            temp = "https://twitter.com/explore";
        }

        //Отправим результат дальше
        manager.beginTransaction()
                .add(R.id.fragment2,ControlActivityWeb.newInstance(temp),"frag2")
                .commit();
    }

}
