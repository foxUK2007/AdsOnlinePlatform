package com.example.adsonlineplatform.mappers;

import com.example.adsonlineplatform.DTOs.CommentDTO;
import com.example.adsonlineplatform.entity.Comment;
import com.example.adsonlineplatform.entity.Users;
import org.mapstruct.*;


@Mapper(
        componentModel = "spring"
)
public abstract class CommentMapper implements GeneralMapper<Comment, CommentDTO>{
    @Override
    @Mappings({
            @Mapping(source = "commentDTO.author", target = "author",
                    qualifiedByName = "authorMapper")
    })
    public abstract Comment fromDto(CommentDTO commentDTO);

    @Override
    @Mapping(source = "author.id", target = "author")
    public abstract CommentDTO toDto(Comment comment);

    @Named("authorMapper")
    Users authorMapper(Integer authorId) {
        if (authorId != null) {
            Users user = new Users();
            user.setId(authorId);
            return user;
        }
        return null;
    }
}
