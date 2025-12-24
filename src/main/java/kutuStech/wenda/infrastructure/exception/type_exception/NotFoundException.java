package kutuStech.wenda.infrastructure.exception.type_exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
