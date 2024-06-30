package com.tobeto.blog.controller;

import com.tobeto.blog.entity.concretes.Post;
import com.tobeto.blog.service.abstracts.PostService;
import com.tobeto.blog.service.dtos.requests.post.AddPostRequest;
import com.tobeto.blog.service.dtos.requests.post.UpdatePostRequest;
import com.tobeto.blog.service.dtos.responses.post.GetPostListResponse;
import com.tobeto.blog.service.dtos.responses.post.GetPostResponse;
import com.tobeto.blog.service.paging.PageInfo;
import com.tobeto.blog.service.responses.GetListResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/posts")
@CrossOrigin
public class PostController {
    private PostService postService;

    @GetMapping("/getAll")
    public List<GetPostListResponse> getAll(){
        return postService.getAll();
    }

    @GetMapping("/page")
    public List<GetPostListResponse> getAllPost(@RequestParam(value = "page")int page, @RequestParam(value = "offset")int offset){
        return postService.findAllPost(page, offset);
    }
    @GetMapping("/{id}")
    public GetPostResponse getById(int id){
        return postService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddPostRequest addPostRequest){
        postService.add(addPostRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdatePostRequest updatePostRequest){
        postService.update(updatePostRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        postService.delete(id);
    }
}
