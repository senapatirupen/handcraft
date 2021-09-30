package com.app.handcraft.service;

import com.app.handcraft.entity.Address;
import com.app.handcraft.entity.Cart;
import com.app.handcraft.entity.Person;
import com.app.handcraft.exception.DataNotFoundException;
import com.app.handcraft.repository.AddressRepository;
import com.app.handcraft.repository.CartRepository;
import com.app.handcraft.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class ProfileManagementServiceImpl implements ProfileManagementService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    private PersonRepository personRepository;

    //TODO: Add address, edit address, delete address, fetch all address
    //TODO: order history, cancel, recent orders, edit order, return
    //TODO: product history, product return
    //TODO: profile management,

    public Collection<Person> findAllPerson() {
        return personRepository.findAll();
    }

    public Optional<Person> findPersonById(Long id) throws DataNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("person not found for id: " + id));
        return personRepository.findById(id);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) throws DataNotFoundException {
        findPersonById(person.getPeId());
        return personRepository.save(person);
    }

    public void deletePersonById(Long id) throws DataNotFoundException {
        findPersonById(id);
        personRepository.deleteById(id);
    }

    public void deletePerson(Person person) throws DataNotFoundException {
        findPersonById(person.getPeId());
        personRepository.delete(person);
    }

    public Boolean existsPersonById(Long id) {
        return personRepository.existsById(id);
    }

    public Address updateAddress(Address address) throws DataNotFoundException {
        findAddressById(address.getAdId());
        return addressRepository.save(address);
    }

    public Collection<Cart> findAllCart() {
        return cartRepository.findAll();
    }

    public Optional<Cart> findCartById(Long id) throws DataNotFoundException {
        cartRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("cart not found for id: " + id));
        return cartRepository.findById(id);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart saveCartToPerson(Cart cart, Long id) throws DataNotFoundException {
        Optional<Person> personOptional =  findPersonById(id);
        cart.setPeId(id);
        saveCart(cart);
        Person person = personOptional.get();
        person.setCart(cart);
        savePerson(person);
        return cartRepository.save(cart);
    }

    public Cart updateCartToPerson(Cart cart, Long id) throws DataNotFoundException {
        findPersonById(id);
        saveCart(cart);
        return cart;
    }

    public Boolean deleteCartFromPerson(Long caId, Long peId) throws DataNotFoundException {
        findPersonById(peId);
        deleteCartById(caId);
        return true;
    }

    public void deleteCartById(Long id) throws DataNotFoundException {
        cartRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("cart not found for id: " + id));
        cartRepository.deleteById(id);
    }

    public void deleteCart(Cart cart) throws DataNotFoundException {
        cartRepository.findById(cart.getCaId())
                .orElseThrow(() -> new DataNotFoundException("cart not found for id: " + cart.getCaId()));
        cartRepository.delete(cart);
    }

    public Boolean existsCartById(Long id) {
        return cartRepository.existsById(id);
    }

    public Collection<Address> findAddressesByPersonId(Long id) throws DataNotFoundException {
        findPersonById(id);
        return personRepository.findAddressesByPersonId(id);
    }

    public Address saveAddressToPerson(Address address, Long id) throws DataNotFoundException {
        Optional<Person> personOptional =  findPersonById(id);
        address.setPeId(id);
        saveAddress(address);
        Person person = personOptional.get();
        person.getAddresses().add(address);
        savePerson(person);
        return address;
    }

    public Address updateAddressToPerson(Address address, Long id) throws DataNotFoundException {
        findPersonById(id);
        saveAddress(address);
        return address;
    }

    public Boolean deleteAddressFromPerson(Long adId, Long peId) throws DataNotFoundException {
        findPersonById(peId);
        deleteAddressById(adId);
        return true;
    }

    public Collection<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    public Optional<Address> findAddressById(Long id) throws DataNotFoundException {
        addressRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("address not found for id: " + id));
        return addressRepository.findById(id);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }

    public Boolean existsAddressById(Long id) {
        return addressRepository.existsById(id);
    }
}
