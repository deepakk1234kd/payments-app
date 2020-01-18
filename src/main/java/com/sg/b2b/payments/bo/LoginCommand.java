package com.sg.b2b.payments.bo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class LoginCommand {

    private String username;
    private String password;

}
