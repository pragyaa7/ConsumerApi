package com.example.consumerApi2.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.example.consumerApi2.constant.Currency;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(NON_NULL)
@Setter
@Getter
public class Fare {

    double amount;
    Currency currency;
    String origin, destination;

}
