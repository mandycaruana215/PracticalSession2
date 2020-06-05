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

public class ScienceTab extends Fragment {
    private GridView gridView;
    private CustomGridAdapter adapter;
    String postSection = "Science";
    List<PostModel> sciencePosts;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragmentscience, container, false);

        sciencePosts = PostModel.getAllPosts(postSection);
        gridView = (GridView) rootView .findViewById(R.id.gridscience);
        adapter = new CustomGridAdapter(getContext(), sciencePosts);
        gridView.setAdapter(adapter);

        return  rootView;
    }
}
