package com.chinna.learn.accounts.service;

import com.chinna.learn.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service()
public interface IAccountsService {


    /**
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);


    /**
     * @param customerDto
     * @return boolean indicating if the updating of account details are successful or not
     */
    boolean updateAccount(CustomerDto customerDto);


    /**
     * @param mobileNumber
     * @return boolean indicating if the account with mobile number is deleted successful or not
     */
    boolean deleteAccount(String mobileNumber);
}
