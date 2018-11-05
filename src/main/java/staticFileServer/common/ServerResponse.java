package staticFileServer.common;

public class ServerResponse<T> {

  private final String code;
  private final String message;
  private T data;

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public T getData() {
    return data;
  }

  public ServerResponse(String code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static <T> ServerResponse<T> createBySuccessMessage(String message) {
    return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), message, null);
  }
}
