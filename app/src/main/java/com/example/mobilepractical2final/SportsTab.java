package com.example.mobilepractical2final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;


public class SportsTab extends Fragment {

    private GridView gridView;
    private CustomGridAdapter adapter;
    String postSection = "Sports";
    List<PostModel> sportsPosts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragmentsports, container, false);
        sportsPosts = PostModel.getAllPosts(postSection);
        gridView = (GridView) rootView .findViewById(R.id.gridsports);
        adapter = new CustomGridAdapter(getContext(), sportsPosts);
        gridView.setAdapter(adapter);

        return  rootView;
    }

}
