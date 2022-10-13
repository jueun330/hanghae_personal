package com.sparta.memberpost;


import com.sparta.memberpost.controller.CustomExceptionHandler;
import com.sparta.memberpost.controller.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final CustomExceptionHandler handler;
    private final MethodArgumentNotValidException ex;

    @Bean
    public ResponseEntity<ErrorResponse> handleValidation (MethodArgumentNotValidException ex) {
        ErrorResponse response = (ErrorResponse) handler.getValidate(ex).getBody();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST) ;
    }

    @Bean
    public MessageSource messageSource() {
        Locale.setDefault(Locale.ROOT);
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("application/json; charset=utf-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator(MessageSource messageSource){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
