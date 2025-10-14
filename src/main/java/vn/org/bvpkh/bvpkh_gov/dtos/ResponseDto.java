package vn.org.bvpkh.bvpkh_gov.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Builder
public class ResponseDto implements Serializable {
    private String message;
    private Object data;
    private HttpStatus status;
}
