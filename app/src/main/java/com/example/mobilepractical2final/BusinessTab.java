package com.example.mobilepractical2final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.List;

public class BusinessTab extends Fragment
{
    private GridView gridView;
    private CustomGridAdapter adapter;
    String postSection = "Business";
    List<PostModel> businessPosts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragmentbusiness, container, false);
        businessPosts = PostModel.getAllPosts(postSection);
        gridView = (GridView) rootView .findViewById(R.id.gridbusiness);
        adapter = new CustomGridAdapter(getContext(), businessPosts);
        gridView.setAdapter(adapter);

        return  rootView;
    }
}
