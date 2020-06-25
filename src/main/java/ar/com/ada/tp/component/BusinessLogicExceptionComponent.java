package ar.com.ada.tp.component;

import ar.com.ada.tp.exception.ApiEntityError;
import ar.com.ada.tp.exception.BusinessLogicException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("businessLogicExceptionComponent")
public class BusinessLogicExceptionComponent {

    public RuntimeException throwExceptionEntityNotFound (String entityName, Long id){
        ApiEntityError apiEntityError = new ApiEntityError()
                .setEntity(entityName)
                .setCode("Not found")
                .setMessage("The " + entityName + " with id " + id + " does not exist");

        return new BusinessLogicException()
                .setDefaultMessage(entityName + "does not exist")
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .setEntityErrors(apiEntityError);
    }

    public RuntimeException throwExceptionEntityAlreadyExist(String entityName,Long id) {
        ApiEntityError apiEntityError = new ApiEntityError()
                .setEntity(entityName)
                .setCode("Already exist")
                .setMessage("The " + entityName + " with id " + id + " already exist");

        return new BusinessLogicException()
                .setDefaultMessage(entityName + "already exist")
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .setEntityErrors(apiEntityError);
    }

    public RuntimeException throwExceptionEntityIsNull (String entityName,Long id, Long id2) {
        ApiEntityError apiEntityError = new ApiEntityError()
                .setEntity(entityName)
                .setCode("Is null")
                .setMessage("The " + entityName + " with id " + id + "y" + id2 + " is null");

        return new BusinessLogicException()
                .setDefaultMessage(entityName + "is null")
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .setEntityErrors(apiEntityError);
    }

}
