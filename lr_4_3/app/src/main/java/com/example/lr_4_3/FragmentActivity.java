package com.example.lr_4_3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentActivity extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public FragmentActivity() {}
    //ф-я, принимающая значения
    public static FragmentActivity newInstance(String param1) {
        FragmentActivity fragment = new FragmentActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Выбор картинки
        ImageView imageView = view.findViewById(R.id.imageView);
        Log.d("k",mParam1);
        if(mParam1.equals("0")){
            imageView.setImageResource(R.drawable.image_1);
        }
        if(mParam1.equals("1")){
            imageView.setImageResource(R.drawable.image_2);
        }
        if(mParam1.equals("2")){
            imageView.setImageResource(R.drawable.image_3);
        }

    }
}
