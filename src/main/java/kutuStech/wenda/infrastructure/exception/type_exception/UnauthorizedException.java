package kutuStech.wenda.infrastructure.exception.type_exception;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String message) {
        super(message);
    }
}
