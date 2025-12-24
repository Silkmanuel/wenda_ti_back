package kutuStech.wenda.adapters.output.config;

public interface TokenServicePort {
    String generateAccessToken(String id);
    Boolean validateAccessToken(String token);
    String extractData(String token);
}
