package com.spring.bootElgamal.University.Course.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstructorBasicDto {
    private Long id;
    private String name;
    private String email;

}
