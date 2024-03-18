package com.example.fotomoto.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClass {
//    private Long id;
    private String imageName;
    private String downloadUrl;
    private String imageType;
    private long imageSize;

}
