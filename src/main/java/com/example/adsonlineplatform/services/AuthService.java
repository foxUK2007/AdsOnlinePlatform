package com.example.adsonlineplatform.services;

import com.example.adsonlineplatform.DTOs.RegisterReqDTO;

/**
 * Интерфейс сервисного класса AuthServiceImpl, содержащий набор CRUD операций над объектом Auth
 *
 */
public interface AuthService {
    /**
     * Метод для авторизации пользователя
     * @param userName
     * @param password
     * @return
     */
    boolean login(String userName, String password);

    /**
     * Метод для регистрации пользователя
     * @param registerReqDTO
     * @return
     */
    boolean register(RegisterReqDTO registerReqDTO);

}
