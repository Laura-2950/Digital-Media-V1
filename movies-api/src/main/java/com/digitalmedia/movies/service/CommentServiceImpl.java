package com.digitalmedia.movies.service;

import com.digitalmedia.movies.model.Comment;
import com.digitalmedia.movies.model.dto.CommentDto;
import com.digitalmedia.movies.repository.CommentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ObjectMapper mapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ObjectMapper mapper) {
        this.commentRepository = commentRepository;
        this.mapper=mapper;
    }

    @Override
    public CommentDto validateAndGetComment(String imdbId){

        Optional<Comment>comment = commentRepository.findById(imdbId);
        CommentDto commentDto = null;
        if (comment.isPresent()){
            commentDto= mapper.convertValue(comment,CommentDto.class);
        }
        return commentDto;
    }

    @Override
    public List<CommentDto> getComments() {
        List<Comment> listComments= commentRepository.findAll();
        List<CommentDto> listCommentsDtos= new ArrayList<>();
        for (Comment comment : listComments) {
            listCommentsDtos.add(mapper.convertValue(comment, CommentDto.class));
        }
        return listCommentsDtos;
    }

    @Override
    public CommentDto saveComment(CommentDto commentDto) {
        Comment comment = mapper.convertValue(commentDto, Comment.class);
        Comment aux= commentRepository.save(comment);
        CommentDto res= null;
        if (!aux.getText().isBlank()){
            res= mapper.convertValue(aux, CommentDto.class);
        }
        return res;
    }

    @Override
    public void deleteComment(CommentDto commentDto) {
        commentRepository.delete(mapper.convertValue(commentDto, Comment.class));
    }
}