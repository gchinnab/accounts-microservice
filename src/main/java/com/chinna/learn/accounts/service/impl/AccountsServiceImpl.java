package com.chinna.learn.accounts.service.impl;

import com.chinna.learn.accounts.constants.AccountsConstants;
import com.chinna.learn.accounts.dto.CustomerDto;
import com.chinna.learn.accounts.entity.Accounts;
import com.chinna.learn.accounts.entity.Customer;
import com.chinna.learn.accounts.exception.CustomerAlreadyExistsException;
import com.chinna.learn.accounts.mapper.CustomerMapper;
import com.chinna.learn.accounts.repository.AccountsRepository;
import com.chinna.learn.accounts.repository.CustomerRepository;
import com.chinna.learn.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(customerOptional.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with mobile number " + customerDto.getMobileNumber() + " already exists");
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous User");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous User");
        return newAccount;
    }
}
