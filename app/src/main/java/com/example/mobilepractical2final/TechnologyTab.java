package com.example.mobilepractical2final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class TechnologyTab extends Fragment
{
    private GridView gridView;
    private CustomGridAdapter adapter;
    String postSection = "Technology";
    List<PostModel> technologyPosts;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragmenttechnology, container, false);
        technologyPosts = PostModel.getAllPosts(postSection);
        gridView = (GridView) rootView .findViewById(R.id.gridtechnology);
        adapter = new CustomGridAdapter(getContext(), technologyPosts);
        gridView.setAdapter(adapter);

        return  rootView;}
}
