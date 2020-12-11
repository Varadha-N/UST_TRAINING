package com.mortgagecalculator;

public interface LendCalculator
{
    double calculateBalance(short numberOfPaymentsMade);

    double calculateMortgate();

    double[] getRemainingBalance();
}
