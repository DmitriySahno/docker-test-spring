package org.sahd.dockertest.customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerDTO customerDTO) {
        return Customer.builder()
                .id(customerDTO.id())
                .name(customerDTO.name())
                .build();
    }

    public CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName()
        );
    }
}
