package com.example.batchMaster.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreateRequest {

    private String username;
    private String email;
    private String password;
}
