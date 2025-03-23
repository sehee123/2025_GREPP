package com.devcourse.app.step2.service;

import com.devcourse.app.step2.data.Post;
import com.devcourse.app.step2.repository.PostRepository;

public class PostService {

    PostRepository postRepository = new PostRepository();

    public int addPost(String title, String body){
        return postRepository.save(title,body);
    }

    public Post getById(int id){
        return postRepository.getById(id);
    }

    public void update(int postId , String title, String body){
        postRepository.update(postId,title,body);
    }

    public void removdById(int id){
        postRepository.removedById(id);
    }
}
