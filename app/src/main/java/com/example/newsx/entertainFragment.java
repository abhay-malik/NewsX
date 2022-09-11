package com.example.newsx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class entertainFragment extends Fragment {

    String apiKey = "420036202ee54283bb65192a5175039b";
    ArrayList<modelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    String category = "entertainment";
    private RecyclerView recyclerViewEntertainment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entertain,null);
        recyclerViewEntertainment = view.findViewById(R.id.enterRecyclerView);
        modelClassArrayList = new ArrayList<>();
        findNews();
        recyclerViewEntertainment.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);

        recyclerViewEntertainment.setAdapter(adapter);
        return view;
    }

    private void findNews(){
        apiUtilities.getApiInterface().getNews(country,category,100,apiKey).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });

    }
}
