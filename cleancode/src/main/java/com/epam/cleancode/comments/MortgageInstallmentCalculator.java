package com.epam.cleancode.comments;

class MortgageInstallmentCalculator {

    private static final int ZERO = 0;
    private static final double TWELVE = 12.0;
    private static final double ONE_HUNDRED = 100.0;
    private static final String INVALID_INPUT_EXCEPTION = "Negative values are not allowed";

    /**
     * @param principalAmount principal amount
     * @param termInYears     term of mortgage in years
     * @param rateOfInterest  rate of interest
     * @return monthly payment amount
     */
    static double calculateMonthlyPayment(int principalAmount,
                                          int termInYears,
                                          double rateOfInterest) {

        negationCheck(principalAmount, termInYears, rateOfInterest);

        rateOfInterest = getRateOfInterestAsDecimal(rateOfInterest);

        double termInMonths = getTermInMonthsFromYears(termInYears);

        if (checkForZeroRate(rateOfInterest)) {
            return principalAmount / termInMonths;
        }

        double monthlyRate = getMonthlyRate(rateOfInterest);

        return getMonthlyPayment(principalAmount, termInMonths, monthlyRate);
    }

    private static double getMonthlyRate(double rateOfInterest) {
        return rateOfInterest / TWELVE;
    }

    private static boolean checkForZeroRate(double rateOfInterest) {
        return rateOfInterest == ZERO;
    }

    private static double getTermInMonthsFromYears(int termInYears) {
        return termInYears * TWELVE;
    }

    private static double getRateOfInterestAsDecimal(double rateOfInterest) {
        rateOfInterest /= ONE_HUNDRED;
        return rateOfInterest;
    }

    private static double getMonthlyPayment(int principalAmount,
                                            double termInMonths,
                                            double monthlyRate) {
        return (principalAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
    }

    private static void negationCheck(int principalAmount,
                                      int termOfMortgageInYears,
                                      double rateOfInterest) {
        if (principalAmount < ZERO || termOfMortgageInYears <= ZERO || rateOfInterest < ZERO) {
            throw new InvalidInputException(INVALID_INPUT_EXCEPTION);
        }
    }
}
