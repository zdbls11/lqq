package com.example.minio;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/3
 */
import lombok.Data;

@Data
public class ObjectItem {
    private String objectName;
    private Long size;
}

