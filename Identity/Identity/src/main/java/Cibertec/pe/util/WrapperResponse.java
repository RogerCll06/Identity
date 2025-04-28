package Cibertec.pe.util;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WrapperResponse <T>{

    private String Token;

    public ResponseEntity<WrapperResponse<T>> createResponse(HttpStatus status){
        return new ResponseEntity<>(this, status);

    }

    public WrapperResponse() {
        super();
    }

    public WrapperResponse(String token) {
        super();
        Token = token;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }



}
