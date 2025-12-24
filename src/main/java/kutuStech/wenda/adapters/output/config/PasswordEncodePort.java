package kutuStech.wenda.adapters.output.config;

public interface PasswordEncodePort {
    String encode(String rawPassord);
    Boolean matches(String rawPassord, String encodePassword);
    String generatePasword();
}
