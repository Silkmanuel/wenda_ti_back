package kutuStech.wenda.infrastructure.exception.type_exception;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String message) {
        super(message);
    }
}
