package staticFileServer.exception;

/**
 * For HTTP 404 errors
 */
public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException() { super(); }

  public ResourceNotFoundException(String message, Throwable cause) { super(message, cause); }

  public ResourceNotFoundException(String message) { super(message); }

  public ResourceNotFoundException(Throwable cause) { super(cause); }
}
