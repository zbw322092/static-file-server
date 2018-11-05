package staticFileServer.common;

public enum ResponseCode {
  SUCCESS("0000", "SUCCESS");

  private final String code;
  private final String desc;

  ResponseCode(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
