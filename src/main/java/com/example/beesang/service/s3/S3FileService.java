package com.example.beesang.service.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3FileService {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}") private String bucket;

    public String uploadImage(String classification, MultipartFile file) {
        try {
            String uuid = UUID.randomUUID().toString();
            String ext = getExt(Objects.requireNonNull(file.getOriginalFilename()));
            String imageName = uuid + "." + ext;

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucket + classification, imageName, file.getInputStream(), metadata);

            return imageName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}
