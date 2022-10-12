package com.sparta.memberpost.global.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
public class CommonResponse<T> {
    boolean success;
    int code;
    String message;

    String error;


}
