package com.banking.javabankingapplication.iban;

import java.util.Random;

public class IBAN {

    private final String COUNTRY_CODE = "HR";
    private final String COUNTRY_NUMBER = "89";
    private final String BANK_NUMBER = "2484008";
    private String iban;

    public IBAN() {
        generateIBAN();
    }

    /**
     * Generates a new IBAN number.
     *
     * @return The generated IBAN number.
     */
    public void generateIBAN(){
        String randomNumber = generateRandomNumber();
        iban =  COUNTRY_CODE + COUNTRY_NUMBER + BANK_NUMBER + randomNumber;
    }

    /**
     * Generates a new random number for the IBAN.
     *
     * @return The generated random number.
     */
    private String generateRandomNumber() {
        Random random = new Random();
        int randomNum = random.nextInt(900000000) + 1000000000;
        return Integer.toString(randomNum);
    }

    public String getIBAN(){
        return iban;
    }
}
