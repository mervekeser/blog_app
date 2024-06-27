package com.tobeto.blog.service.concretes;

import com.tobeto.blog.entity.concretes.Post;
import com.tobeto.blog.repository.PostRepository;
import com.tobeto.blog.service.abstracts.PostService;
import com.tobeto.blog.service.constants.Messages;
import com.tobeto.blog.service.dtos.requests.post.AddPostRequest;
import com.tobeto.blog.service.dtos.requests.post.UpdatePostRequest;
import com.tobeto.blog.service.dtos.responses.post.*;
import com.tobeto.blog.service.mappers.PostMapper;
import com.tobeto.blog.service.paging.PageInfo;
import com.tobeto.blog.service.responses.GetListResponse;
import com.tobeto.blog.service.rules.PostBusinessRules;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostManager implements PostService {

    private final PostRepository postRepository;
    private final PostBusinessRules postBusinessRules;
    private final PostMapper postMapper;

    @Override
    public GetPostResponse getById(int id) {
        postBusinessRules.checkByPostId(id);
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(Messages.PostMessages.POST_NOT_FOUND + id));
        return postMapper.postToGetPostResponse(post);
    }

    @Override
    public List<GetPostListResponse> getAll() {
       return postRepository.findAll().stream()
                .map(postMapper::postToGetPostListResponse)
                .collect(Collectors.toList());
    }


    @Override
    public void add(AddPostRequest addPostRequest) {
        Post post = PostMapper.INSTANCE.addPostRequest(addPostRequest);
         postRepository.save(post);

    }

    @Override
    public void update(UpdatePostRequest updatePostRequest) {
        postBusinessRules.checkByPostId(updatePostRequest.getId());
        Post post = PostMapper.INSTANCE.updatePostRequest(updatePostRequest);
        postRepository.save(post);
    }

    @Override
    public void delete(int id) {
        postBusinessRules.checkByPostId(id);
        postRepository.deleteById(id);
    }
}
