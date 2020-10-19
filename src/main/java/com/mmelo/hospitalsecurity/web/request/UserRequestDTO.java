package com.mmelo.hospitalsecurity.web.request;

import com.mmelo.hospitalsecurity.enumerator.ProfileType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private String email;
    private String password;
    private ProfileType profileType;
}
