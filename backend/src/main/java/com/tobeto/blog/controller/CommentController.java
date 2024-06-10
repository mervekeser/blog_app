package com.tobeto.blog.controller;

import com.tobeto.blog.service.abstracts.CommentService;
import com.tobeto.blog.service.dtos.requests.comment.AddCommentRequest;
import com.tobeto.blog.service.dtos.requests.comment.UpdateCommentRequest;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentListResponse;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/comments")
@CrossOrigin
public class CommentController {
    private CommentService commentService;

    @GetMapping("/getAll")
    public List<GetCommentListResponse> getAll(){
        return commentService.getAll();
    }

    @GetMapping("{id}")
    public GetCommentResponse getById(int id){
        return commentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddCommentRequest addCommentRequest){
        commentService.add(addCommentRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCommentRequest updateCommentRequest){
        commentService.update(updateCommentRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        commentService.delete(id);
    }
}
