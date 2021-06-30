package ro.utcluj.bookstore.exception;

public class ValidationFailedException extends RuntimeException {

  public ValidationFailedException(String message) {
    super(message);
  }
}
