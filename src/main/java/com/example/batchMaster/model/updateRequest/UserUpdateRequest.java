package com.example.batchMaster.model.updateRequest;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserUpdateRequest {

    private String userId;
    private String username;
    private String email;
    private String password;
}
