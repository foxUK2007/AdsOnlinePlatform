package com.example.adsonlineplatform.controllers;

import com.example.adsonlineplatform.services.FileService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Tag(name = "Файлы", description = "Файлы")
public class FileController {
    private final FileService fileService;

    @GetMapping("/{entityName}/{entityId}/{fileName}")
    @ResponseBody
    public HttpEntity<byte[]> getFileByFileName(
            @Parameter(description = "Тип сущности") @PathVariable(value = "entityName") String entityName,
            @Parameter(description = "Идентификатор сущности") @PathVariable(value = "entityId") String entityId,
            @Parameter(description = "Имя файла") @PathVariable(value = "fileName") String fileName
    ) {
        byte[] documentBody = fileService.getFile(entityName,entityId,fileName);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        header.setContentLength(documentBody.length);
        return new HttpEntity<>(documentBody, header);
    }
}
