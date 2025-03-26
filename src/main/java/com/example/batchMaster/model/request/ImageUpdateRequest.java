package com.example.batchMaster.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageUpdateRequest {
    private String studentId;
    private String imgUrl;


}
