package supermarkethibernate.service.custom;

import supermarkethibernate.dto.CustomerDto;
import supermarkethibernate.service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService {
    String saveCustomer(CustomerDto customerDto);

    String updateCustomer(CustomerDto customerDto);

    String deleteCustomer(String id);

    CustomerDto getCustomer(String id);

    List<CustomerDto> getAllCustomers();
}
