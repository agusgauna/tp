package ar.com.ada.tp.component;

import ar.com.ada.tp.exception.ApiEntityError;
import ar.com.ada.tp.exception.BusinessLogicException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("businessLogicExceptionComponent")
public class BusinessLogicExceptionComponent {

    public void throwExceptionEntityNotFound (String entityName, Long id){
        ApiEntityError apiEntityError = new ApiEntityError(
                entityName,
                "NotFound",
                "The actor with id " + id + "does not exist"
        );
        throw new BusinessLogicException(
                entityName + "not exist",
                HttpStatus.NOT_FOUND,
                apiEntityError
        );
    }
}
