package ar.com.ada.tp.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiEntityError {

    private String entity, code, message;

    public ApiEntityError(String entity, String code, String message) {
        this.entity = entity;
        this.code = code;
        this.message = message;
    }

    public ApiEntityError setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public ApiEntityError setCode(String code) {
        this.code = code;
        return this;
    }

    public ApiEntityError setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "ApiEntityError{" +
                "entity='" + entity +
                ", code='" + code +
                ", message='" + message;
    }
}
