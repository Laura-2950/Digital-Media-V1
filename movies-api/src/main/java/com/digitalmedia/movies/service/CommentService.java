package com.digitalmedia.movies.service;

import com.digitalmedia.movies.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto validateAndGetComment(String imdbId);

    List<CommentDto> getComments();

    CommentDto saveComment(CommentDto comment);

    void deleteComment(CommentDto comment);
}