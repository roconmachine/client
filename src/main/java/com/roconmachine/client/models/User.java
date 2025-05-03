package com.roconmachine.client.models;

import com.roconmachine.client.core.AppRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends AppRequest {

    private String username;
    private String email;

    private String role;
}
