/**
 * The IBAN class represents an International Bank Account Number.
 */
package com.banking.javabankingapplication;

import java.util.Locale;
import java.util.Random;

public class IBAN {
    /**
     * The country code for the IBAN.
     */
    private static final String COUNTRY_CODE = "HR";

    /**
     * The two-digit country number for the IBAN.
     */
    private static final String COUNTRY_NUMBER = "89";

    /**
     * The eight-digit bank number for the IBAN.
     */
    private static final String BANK_NUMBER = "2484008";

    /**
     * Constructs a new IBAN object.
     */
    public IBAN() {
        generateIBAN();
    }

    /**
     * Generates a new IBAN number.
     *
     * @return The generated IBAN number.
     */
    public static String generateIBAN(){
        String randomNumber = generateRandomNumber();
        String iban =  COUNTRY_CODE + COUNTRY_NUMBER + BANK_NUMBER + randomNumber;
        return iban;
    }

    /**
     * Generates a new random number for the IBAN.
     *
     * @return The generated random number.
     */
    private static String generateRandomNumber() {
        Random random = new Random();
        int randomNum = random.nextInt(900000000) + 1000000000;
        return Integer.toString(randomNum);
    }

}
