package n2ntechnicalassessment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@ToString
public class ResponseDTO<T> {

    private T data;

    private int status;

    private String errorCode;

    public ResponseDTO(HttpStatus status) {
        this.status = status.value();
    }


    public ResponseDTO(T body, int status) {
        this.data = body;
        this.status = status;
    }

    public ResponseDTO(T body, HttpStatus status) {
        this.data = body;
        this.status = status.value();
    }


}
