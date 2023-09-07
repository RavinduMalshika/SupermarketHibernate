package supermarkethibernate.service.custom.impl;

import org.hibernate.Session;
import supermarkethibernate.dao.DaoFactory;
import supermarkethibernate.dao.custom.CustomerDao;
import supermarkethibernate.dto.CustomerDto;
import supermarkethibernate.entity.CustomerEntity;
import supermarkethibernate.service.custom.CustomerService;
import supermarkethibernate.util.SessionFactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity(
                customerDto.getId(),
                customerDto.getTitle(),
                customerDto.getName(),
                customerDto.getDob(),
                customerDto.getSalary(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getPostalCode()
        );

        if(customerDao.save(customerEntity, session)) {
            return "Successfully Saved";
        } else {
            return "Failed";
        }
    }

    @Override
    public String updateCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity(
                customerDto.getId(),
                customerDto.getTitle(),
                customerDto.getName(),
                customerDto.getDob(),
                customerDto.getSalary(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getPostalCode()
        );

        if(customerDao.update(customerEntity, session)) {
            return "Successfully Saved";
        } else {
            return "Failed";
        }
    }

    @Override
    public String deleteCustomer(String id) {
        if(customerDao.delete(id, session)) {
            return "Successfully Saved";
        } else {
            return "Failed";
        }
    }

    @Override
    public CustomerDto getCustomer(String id) {
        CustomerEntity customerEntity = customerDao.get(id, session);
        return new CustomerDto(
                customerEntity.getId(),
                customerEntity.getTitle(),
                customerEntity.getName(),
                customerEntity.getDob(),
                customerEntity.getSalary(),
                customerEntity.getAddress(),
                customerEntity.getCity(),
                customerEntity.getProvince(),
                customerEntity.getPostalCode()
        );
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        List<CustomerEntity> customerEntities = customerDao.getAll(session);

        for (CustomerEntity customerEntity : customerEntities) {
            CustomerDto customerDto = new CustomerDto(
                    customerEntity.getId(),
                    customerEntity.getTitle(),
                    customerEntity.getName(),
                    customerEntity.getDob(),
                    customerEntity.getSalary(),
                    customerEntity.getAddress(),
                    customerEntity.getCity(),
                    customerEntity.getProvince(),
                    customerEntity.getPostalCode()
            );
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }
}
