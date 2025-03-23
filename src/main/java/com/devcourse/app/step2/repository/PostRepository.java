package com.devcourse.app.step2.repository;

import com.devcourse.app.step2.data.Post;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {

    private int sequence = 0;
    private List<Post> postList = new ArrayList<>();

    public int save(String title , String body){
        Post newPost = new Post(sequence,title,body);
        postList.add(newPost);
        return newPost.getId();
    }

    public Post getById(int id){
        return postList.get(id-1);
    }

    public void update(int postId , String title , String body){
        Post findPost = getById(postId);

        findPost.setTitle(title);
        findPost.setBody(body);
        findPost.setUpdatedAt(LocalDate.now());
    }

    public void removedById(int postId){
        Post findPost = getById(postId);

        if (findPost != null){
            postList.set(postId-1, null);
        }
    }


}
