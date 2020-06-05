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


public class WorldTab extends Fragment {

    private GridView gridView;
    private CustomGridAdapter adapter;
    String postSection = "World";
    List<PostModel> worldPosts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragmentworld, container, false);
        worldPosts = PostModel.getAllPosts(postSection);
        gridView = (GridView) rootView .findViewById(R.id.gridworld);
        adapter = new CustomGridAdapter(getContext(), worldPosts);
        gridView.setAdapter(adapter);

        return  rootView;
    }

}
