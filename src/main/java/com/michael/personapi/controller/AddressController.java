package com.michael.personapi.controller;

import com.michael.personapi.model.Address;
import com.michael.personapi.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public Page<Address> findAll(Pageable page) {
        return addressService.findAllAddresses(page);
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) {
        return addressService.findAddressById(id);
    }
}
