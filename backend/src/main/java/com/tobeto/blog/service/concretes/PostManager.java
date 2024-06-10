package com.tobeto.blog.service.concretes;

import com.tobeto.blog.core.utilities.mappers.ModelMapperService;
import com.tobeto.blog.entity.concretes.Post;
import com.tobeto.blog.repository.PostRepository;
import com.tobeto.blog.service.abstracts.PostService;
import com.tobeto.blog.service.dtos.requests.comment.UpdateCommentRequest;
import com.tobeto.blog.service.dtos.requests.post.AddPostRequest;
import com.tobeto.blog.service.dtos.requests.post.UpdatePostRequest;
import com.tobeto.blog.service.dtos.responses.post.GetPostListResponse;
import com.tobeto.blog.service.dtos.responses.post.GetPostResponse;
import com.tobeto.blog.service.rules.PostBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostManager implements PostService {
    private ModelMapperService modelMapperService;
    private final PostRepository postRepository;
    private final PostBusinessRules postBusinessRules;

    @Override
    public GetPostResponse getById(int id) {
        Post post = postBusinessRules.checkByPostId(id);
        GetPostResponse getPostResponse = modelMapperService.forResponse()
                .map(post, GetPostResponse.class);
        return getPostResponse;
    }

    @Override
    public List<GetPostListResponse> getAll() {
        List<Post> postList = postRepository.findAll();

        List<GetPostListResponse> postListResponses = postList.stream()
                .map(post -> this.modelMapperService.forResponse()
                        .map(post, GetPostListResponse.class)).collect(Collectors.toList());
        return postListResponses;
    }

    @Override
    public void add(AddPostRequest addPostRequest) {
        Post post = this.modelMapperService.forRequest()
                .map(addPostRequest, Post.class);
        postRepository.save(post);
    }

    @Override
    public void update(UpdatePostRequest updatePostRequest) {
        postBusinessRules.checkByPostId(updatePostRequest.getId());
        Post post = this.modelMapperService.forRequest()
                .map(updatePostRequest, Post.class);
        postRepository.save(post);
    }

    @Override
    public void delete(int id) {
        postBusinessRules.checkByPostId(id);
        postRepository.deleteById(id);
    }
}
