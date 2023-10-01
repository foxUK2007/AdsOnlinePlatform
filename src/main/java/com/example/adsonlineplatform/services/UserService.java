package com.example.adsonlineplatform.services;

import com.example.adsonlineplatform.DTOs.NewPasswordDTO;
import com.example.adsonlineplatform.DTOs.RegisterReqDTO;
import com.example.adsonlineplatform.DTOs.UserDTO;
import com.example.adsonlineplatform.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

/**
 * Интерфейс сервисного класса UserServiceImpl, содержащий набор CRUD операций над объектом User
 */


public interface UserService extends UserDetailsService {
    /**
     * Метод регистрации пользователя
     * @param registerReqDTO
     * @return
     */
    UserDTO create(RegisterReqDTO registerReqDTO);

    /**
     * Метод поиска пользователя по логину
     * @param username
     * @return
     */

    Users findUserByLogin(String username);

    /**
     * Метод изменение пароля
     * @param newPassword
     * @param principal
     */
    void updateUserPassword(NewPasswordDTO newPassword, Principal principal);

    /**
     * Метод загрузки аватара
     * @param principal
     * @param multipartFile
     */
    void updateUserImage(Principal principal, MultipartFile multipartFile);

    /**
     * Метод получения пользователей
     * @param principal
     * @return
     */
    UserDTO getUser(Principal principal);

    /**
     * Метод
     * @param userName
     * @return
     */
    boolean isExist(String userName);

    /**
     * Метод
     * @param userDTO
     * @param principal
     * @return
     */
    UserDTO updateUser(UserDTO userDTO, Principal principal);
}