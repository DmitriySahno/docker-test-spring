package org.sahd.dockertest.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public List<CustomerDTO> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toCustomerDTO)
                .toList();
    }

    public CustomerDTO getById(Long id) {
        return mapper.toCustomerDTO(
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFound("Customer not found by id: " + id)));
    }

    public CustomerDTO add(CustomerDTO customerDTO) {
        return mapper.toCustomerDTO(
                        repository.save(
                                mapper.toCustomer(customerDTO)
                        )
                );
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
