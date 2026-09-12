package com.chinna.learn.accounts.service;

import com.chinna.learn.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service()
public interface IAccountsService {


    /**
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

}
