import java.util.Arrays;
import java.util.List;

/**
 * AUTHOR: Alan Schwartz Jr.
 * LAST UPDATED: 04/12/16
 */

// package edu.easternct.bigdata;

public class ProviderValidator extends Provider {

    final String[] STATECODES = {"AA", "AE", "AK", "AL", "AP", "AR", "AS", "AZ", "CA", "CO", "CT", "DC",
            "DE", "FL", "FM", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS",
            "KY", "LA", "MA", "MD", "ME", "MH", "MI", "MN", "MO", "MP", "MS", "MT", "NC", "ND", "NE", "NH",
            "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "PW", "RI", "SC", "SD", "TN",
            "TX", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY"};
    final List<String> STATELIST = Arrays.asList(STATECODES);

    final String[] ENTITYCODES = {"O", "I"};
    final List<String> ENTITYLIST = Arrays.asList(ENTITYCODES);

    final String[] GENDERCODES = {"F", "M"};
    final List<String> GENDERLIST = Arrays.asList(GENDERCODES);

    /*  error count */
    int errorCnt = 0;

    String line;
    boolean clean;

    public ProviderValidator() {

        this.line = null;
    }

    public ProviderValidator(String line) {
        super();
        this.line = line;
    }

    /**
     * @return clean indicator
     */
    public boolean isClean() {
        return clean;
    }

    /**
     * @param clean the clean to set
     */
    public void setClean(boolean clean) {
        this.clean = clean;
    }

    /**
     * @return the errorCnt
     */
    public int getErrorCnt() {
        return errorCnt;
    }

    /**
     * @param errorCnt the errorCnt to set
     */
    public void setErrorCnt(int errorCnt) {
        this.errorCnt = errorCnt;
    }

    public boolean parser() {
        String[] tokens = line.split(",");
        if (tokens.length != 28) {
            System.out.println("Invalid Number of Tokens");
            errorCnt++;
        }

// validate NPI

        if (validateNPI(tokens[0]))
            this.npi = Long.parseLong(tokens[0]);
        else {
            this.npi = null;
            System.out.println("Invalid NPI");
        }

// validate EntityCode

        if (validateEntityCode(tokens[6]))
            this.nppes_entity_code = tokens[6];
        else {
            this.nppes_entity_code = null;
            System.out.println("Invalid Entity Code");
        }

// validate Gender

        if (validateGender(tokens[5]))
            this.nppes_provider_gender = tokens[5];
        else {
            this.nppes_provider_gender = null;
            System.out.println("Invalid Gender");
        }

// validate State

        if (validateState(tokens[11]))
            this.nppes_provider_state = tokens[11];
        else {
            this.nppes_provider_state = null;
            System.out.println("Invalid State");
        }

// validate Provider_Type

        if (validateProviderType(tokens[13]))
            this.provider_type = tokens[13];
        else {
            this.provider_type = null;
            System.out.println("Invalid Provider Type");
        }

        System.out.println("Errors for line: " + errorCnt);
        if (errorCnt > 0) {
            setClean(false);
            return false;
        } else
            setClean(true);
        return true;
    }

    public boolean validateNPI(String npi) {
        boolean valid = true;
        if ((npi == null) || (!npi.matches("^\\d+$"))) {
            valid = false;
            errorCnt++;
        }
        return valid;
    }

    private boolean validateEntityCode(String token) {
        boolean valid = true;
        if (!ENTITYLIST.contains(token)) {
            valid = false;
            errorCnt++;
        }
        return valid;
    }

    private boolean validateGender(String token) {
        boolean valid = true;
        if (!GENDERLIST.contains(token) & !(token.isEmpty() & this.nppes_entity_code.equals("O"))) {
            valid = false;
            errorCnt++;
        }
        return valid;
    }

    private boolean validateState(String token) {
        boolean valid = true;
        if (!STATELIST.contains(token)) {
            valid = false;
            errorCnt++;
        }
        return valid;
    }

    private boolean validateProviderType(String token) {
        boolean valid = true;
        if (token == null || token.isEmpty()) {
            valid = false;
            errorCnt++;
        }
        return valid;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return npi + "," + nppes_entity_code + "," + nppes_provider_gender + ","
                + nppes_provider_state + "," + provider_type;
    }


}


