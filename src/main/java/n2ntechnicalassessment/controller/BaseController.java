package n2ntechnicalassessment.controller;

import n2ntechnicalassessment.dto.ResponseDTO;
import org.springframework.http.HttpStatus;

public abstract class BaseController {

    protected <T> ResponseDTO<T> createResponse(HttpStatus status) {
        return new ResponseDTO<>(status);
    }

    protected <T> ResponseDTO<T> createResponse(HttpStatus status, T body) {
        return new ResponseDTO<>(body, status);
    }

}
