package org.sahd.dockertest.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController()
@RequestMapping("/customers")
public class CustomerController {

    final CustomerService service;

    @GetMapping()
    public List<CustomerDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping()
    public CustomerDTO add(@RequestBody CustomerDTO customerDTO) {
        return service.add(customerDTO);
    }

    @PutMapping()
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO) {
        return service.add(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
