package com.example.lr_4_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ControlActivityWeb extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public ControlActivityWeb() {}

    public static ControlActivityWeb newInstance(String param1) {
        ControlActivityWeb fragment = new ControlActivityWeb();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        //возвращаем фрагмен
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
        return inflater.inflate(R.layout.activity_web, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //При клике переходим по ссылке
        WebView webView = view.findViewById(R.id.webView_id);
        webView.loadUrl(mParam1);
    }
}
