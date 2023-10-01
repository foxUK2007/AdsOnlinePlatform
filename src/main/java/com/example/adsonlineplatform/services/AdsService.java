package com.example.adsonlineplatform.services;

import com.example.adsonlineplatform.DTOs.AdsDTO;
import com.example.adsonlineplatform.DTOs.CreateAdsDTO;
import com.example.adsonlineplatform.DTOs.FullAdsDTO;
import com.example.adsonlineplatform.DTOs.ResponsesWrapperAdsDTO;
import java.security.Principal;


/**
 * Интерфейс сервисного класса AdsServiceImpl, содержащий набор CRUD операций над объектом Ads
 *
 */
public interface AdsService {

    /**
     * Метод ищет и возвращает список всех объявлений
     *
     * @return ResponseWrapperAdsDTO
     */
    ResponsesWrapperAdsDTO getAllAds();
    ResponsesWrapperAdsDTO getAllAdsMe(Principal principal);

    /**
     * Метод создает объявление
     *
     * @param adsDTO
     * @param principal
     * @return AdsDto
     */
    AdsDTO createAds(String adsDTO, Principal principal);

    /**
     * Метод ищет и возвращает объявление по id
     *
     * @param id
     * @return FullAdsDTO
     */
    FullAdsDTO getFullAdsDTO(Integer id);

    /**
     * Метод удаляет объявление по id
     *
     * @param id
     */
    void deleteAdsDTO(Integer id);

    /**
     * Метод редактирует объявление по id
     *
     * @param id
     * @param createAdsDTO
     * @return AdsDTO
     */
    AdsDTO updateAdsDTO(Integer id, CreateAdsDTO createAdsDTO);
}