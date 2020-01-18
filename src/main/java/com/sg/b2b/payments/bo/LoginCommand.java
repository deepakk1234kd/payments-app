package com.sg.b2b.payments.bo;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Builder
public class LoginCommand implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

}
