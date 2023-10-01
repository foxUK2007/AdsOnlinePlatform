package com.example.adsonlineplatform.mappers;

import com.example.adsonlineplatform.DTOs.RegisterReqDTO;
import com.example.adsonlineplatform.DTOs.UserDTO;
import com.example.adsonlineplatform.entity.Users;
import com.example.adsonlineplatform.enums.Roles;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Класс - мапперов пользователя
 */

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper implements GeneralMapper<Users, UserDTO> {

    public Users fromRegisterReqDTO(RegisterReqDTO dto) {
        if (dto == null) {
            return null;
        }
        Users user = new Users();
        user.setUserName(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setRole(Roles.USER);
        return user;
    }

    @Override
    @Mapping(source = "email", target = "userName")
    public abstract Users fromDto(UserDTO userDTO);

    @Override
    @Mapping(source = "userName", target = "email")
    public abstract UserDTO toDto(Users users);
}
