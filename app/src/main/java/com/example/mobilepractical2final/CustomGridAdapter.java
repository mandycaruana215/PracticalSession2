package com.example.mobilepractical2final;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomGridAdapter extends BaseAdapter {

    private Context myContext;
    public List<PostModel> myPosts;

    public CustomGridAdapter(Context context, List<PostModel> posts)
    {
        this.myContext = context;
        this.myPosts = posts;
    }

    @Override
    public int getCount() {
        return myPosts.size();
    }

    @Override
    public Object getItem(int position) {
        return myPosts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.postimageview, null);
        }

        ImageView imageView = (ImageView)gridView.findViewById(R.id.imageviewpost);
        imageView.setImageURI(Uri.parse(myPosts.get(position).imageDirectory));

        TextView textView = (TextView)gridView.findViewById(R.id.Title);
        textView.setText(myPosts.get(position).postName);

        Log.v("CGA", myPosts.get(position).imageDirectory + myPosts.get(position).postName);

        return gridView;
    }

}