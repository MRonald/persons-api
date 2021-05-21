package com.michael.personapi.services;

import com.michael.personapi.model.Address;
import com.michael.personapi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Page<Address> findAllAddresses(Pageable page) {
        return addressRepository.findAll(page);
    }

    public Address findAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElseGet(Address::new);
    }
}
