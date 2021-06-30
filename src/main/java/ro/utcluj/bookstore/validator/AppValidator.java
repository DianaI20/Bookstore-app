package ro.utcluj.bookstore.validator;

public interface AppValidator<T> {

  void validate(T t);
}
