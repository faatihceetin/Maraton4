package org.fatihcetin.exception;
import lombok.Getter;

@Getter
public class WhoMIException extends RuntimeException{

        private final ErrorType ErrorType;
    public org.fatihcetin.exception.ErrorType getErrorType;

    public WhoMIException(ErrorType EErrorType){
        super(EErrorType.getMessage());
        this.ErrorType = EErrorType;
    }

    public WhoMIException(ErrorType EErrorType, String message){
        super(message);
        this.ErrorType = EErrorType;
    }
}
