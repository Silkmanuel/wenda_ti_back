package kutuStech.wenda.infrastructure.config;

public class DefaultApiResponse<T> {
    private int status;
    private Boolean success;
    private String error;
    private String message;
    private T data;

    public DefaultApiResponse(int status, Boolean success,String error, String message, T data) {
        this.status = status;
        this.success = success;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public int getStatus() { return status; }
    public Boolean getSuccess() { return success; }
    public String getError() { return error; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}
