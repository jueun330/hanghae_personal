package com.sparta.memberpost.global;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
@Builder
public class CommonResponse<T> {

    private T result;

    public CommonResponse(T data) {
        this.result = data;
    }

    @Getter
    @NoArgsConstructor

    public static class ofList<T> {
        private List<T> result;

        public ofList(List<T> data) {
            this.result = data;
        }

        private String error;

    }
}
