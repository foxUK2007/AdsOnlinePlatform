package com.example.adsonlineplatform.services;

import com.example.adsonlineplatform.DTOs.CommentDTO;

import java.security.Principal;
import java.util.List;

public interface CommentService {

    List<CommentDTO> getCommentsByAdId(int adId);
    CommentDTO addComment(int adId, CommentDTO comment, Principal principal);

    CommentDTO updateComment(int adId, long commentId, CommentDTO comment);

    void deleteComment(long IdAds, long commentId);

    CommentDTO getCommentById(long IdAds, long commentId);
}
