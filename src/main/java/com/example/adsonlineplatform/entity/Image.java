package com.example.adsonlineplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "image")
public class Image {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    /**
     * Объявление
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ads_id", nullable = false)
    private Ads ads;
    /**
     * Ссылка на картинку
     */
    @Column(name = "image_ref", length = Integer.MAX_VALUE)
    private String imageRef;

}