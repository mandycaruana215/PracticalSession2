package com.example.mobilepractical2final;

import android.graphics.Bitmap;
import android.widget.Toast;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "PostsTable")
public class PostModel extends Model {

    @Column(name = "post_name")
    public String postName;

    @Column(name = "post_content")
    public String postContent;

    @Column(name = "post_section")
    public String postSection;

    @Column(name = "image_directory")
    public String imageDirectory;

    public PostModel() {
    super();
    }

    public PostModel (String postName, String postContent, String postSection, String imageDirectory){
        super();
        this.postName = postName;
        this.postContent = postContent;
        this.postSection = postSection;
        this.imageDirectory = imageDirectory;

        //this.SavePost(this.postName, this.postContent, this.postSection, this.imageDirectory);
    }

    public void SavePost(String postName, String desc, String content, String image) {

        PostModel post = new PostModel();

        post.postName = postName;
        post.postContent = desc;
        post.postSection = content;
        post.imageDirectory = image;
        post.save();

    }

    public static List<PostModel> getAllPosts(String postSection) {
        return new Select()
                .from(PostModel.class)
                .where("post_section = ?", postSection)
                .execute();
    }


}

