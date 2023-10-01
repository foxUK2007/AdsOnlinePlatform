package com.example.adsonlineplatform.services.impl;

import com.example.adsonlineplatform.DTOs.CommentDTO;
import com.example.adsonlineplatform.entity.Ads;
import com.example.adsonlineplatform.entity.Comment;
import com.example.adsonlineplatform.entity.Users;
import com.example.adsonlineplatform.exception.NotFoundInDataBaseException;
import com.example.adsonlineplatform.mappers.CommentMapper;
import com.example.adsonlineplatform.repository.CommentRepository;
import com.example.adsonlineplatform.services.CommentService;
import com.example.adsonlineplatform.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
    public List<CommentDTO> getCommentsByAdId(int adId) {
        return commentRepository.findAllByAds_Id(adId).stream().map(commentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CommentDTO addComment(int adId, CommentDTO commentDTO, Principal principal) {
        Users user = userService.findUserByLogin(principal.getName());
        Ads ads = new Ads();
        ads.setId(adId);
        Comment comment = commentMapper.fromDto(commentDTO);
        comment.setAuthor(user);
        comment.setCreatedAt(LocalDate.now().toString());
        comment.setAds(ads);
        return commentMapper.toDto(commentRepository.saveAndFlush(comment));
    }

    @Override
    @Transactional
    public CommentDTO updateComment(int adId, long commentId, CommentDTO commentDTO) {
        Comment existingComment = commentMapper.fromDto(commentDTO);
        return commentMapper.toDto(commentRepository.saveAndFlush(existingComment));
    }

    @Override
    @Transactional
    public void deleteComment(long IdAds, long commentId) {

        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundInDataBaseException("Comment not found"));

        if (existingComment.getAds().getId() != IdAds) {
            throw new IllegalArgumentException("Comment does not belong to the specified ad");
        }
        commentRepository.deleteById(commentId);
    }

    @Override
    @Transactional(readOnly = true)
    public CommentDTO getCommentById(long IdAds, long commentId) {
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundInDataBaseException("Comment not found"));

        if (existingComment.getAds().getId() != IdAds) {
            throw new IllegalArgumentException("Comment does not belong to the specified ad");
        }

        return commentMapper.toDto(existingComment);
    }
}
