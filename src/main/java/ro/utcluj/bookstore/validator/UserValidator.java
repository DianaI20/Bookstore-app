package ro.utcluj.bookstore.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ro.utcluj.bookstore.exception.ValidationFailedException;
import ro.utcluj.bookstore.model.Customer;

@Component
public class UserValidator implements AppValidator<Customer> {

  @Override
  public void validate(Customer customer) {
    if (customer == null) {
      throw new ValidationFailedException("User must not be null!");
    } else if (StringUtils.isBlank(customer.getName())) {
      throw new ValidationFailedException("Name not specified");
    }else if((StringUtils.isBlank(customer.getAdress()))){
      throw new ValidationFailedException("Adress not specified");
    }
    else if (StringUtils.isBlank(customer.getPhoneNumber())) {
      throw new ValidationFailedException("Phone number not specified");
    }
  }
}
