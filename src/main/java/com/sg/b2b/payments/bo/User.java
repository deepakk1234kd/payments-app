package com.sg.b2b.payments.bo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class User {

    private String username;
    private String password;

}
