package com.example.mobilepractical2final;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.activeandroid.ActiveAndroid;


public class AddPostActivity extends AppCompatActivity
{
    EditText title, description, section;
    ImageView PostImage;
    Button Return;
    Button Submit;
    private static final int PICK_IMAGE = 1000;
    private static final int PERMISSION_CODE = 1001;
    public Uri ImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        if(ContextCompat.checkSelfPermission(AddPostActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(AddPostActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if(ContextCompat.checkSelfPermission(AddPostActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(AddPostActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        Return = (Button)findViewById(R.id.Return);
        Return.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AddPostActivity.this, MainActivity.class));
            }
        });

        Submit = (Button) findViewById(R.id.Submit);
        Submit.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                ActiveAndroid.initialize(AddPostActivity.this);

                title = (EditText) findViewById(R.id.title);
                description = (EditText)findViewById((R.id.description));
                section = (EditText) findViewById(R.id.post_section);

                String postName = title.getText().toString();
                String desc = description.getText().toString();
                String content = section.getText().toString();
                String image = ImageUri.toString();

                PostModel pm = new PostModel(postName, desc, content, image);
                pm.save();

                Toast.makeText(getApplicationContext(), postName + desc + content + image, Toast.LENGTH_LONG).show();
                startActivity(new Intent(AddPostActivity.this, MainActivity.class));
            }
        });

        PostImage = (ImageView) findViewById(R.id.post_Image);
        PostImage.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
                    {
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else
                    {
                        selectImage();
                    }
                }
                else
                {
                    selectImage();
                }
            }
        });

    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK)
        {
            ImageUri = data.getData();
            PostImage.setImageURI(ImageUri);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    selectImage();
                }
                else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void selectImage()
    {
        Intent gallery = new Intent(Intent.ACTION_PICK);
        gallery.setType("image/*");
        gallery.setAction(Intent.ACTION_OPEN_DOCUMENT);
        startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
        //startActivityForResult(gallery, PICK_IMAGE);
    }
}