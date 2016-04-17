/**
 * AUTHOR: Alan Schwartz Jr.
 * LAST UPDATED: 04/12/16
 */

import java.io.Serializable;

// package edu.easternct.bigdata;

public class Provider implements Comparable, Serializable {

    /**
     * LOCAL VARIABLES
     */

	/*
     * Omitted data variables are due to variation between the same provider. I
	 * feel there is no point in collecting these since they will not be a
	 * factor in whether an object is distinct or not. In fact, it could gum up
	 * the works if we trick the application into thinking two instances of the
	 * same provider are distinct from one another because they are different
	 * based on one variable that can be different. These may be added later to
	 * expand the usefulness of this class beyond the current assignment.
	 */

    // [0] National Provider Identifier
    Long npi;

    // [1] Last name of Individual ('I') or name of Organization ('O')
    String nppes_provider_last_org_name;

    // [2] First name of Individual ('I') or blank for Organization ('O')
    String nppes_provider_first_name;

    // [3] Middle initial of Individual ('I') or blank for Organization ('O')
    String nppes_provider_m_i;

    // [4] Credentials of Individual ('I') or blank for Organization ('O')
    String nppes_credentials;

    // [5] Gender of Individual ('I') or blank for Organization ('O')
    String nppes_provider_gender;

    // [6] 'I' for Individual or 'O' for Organization
    String nppes_entity_code;

    // [7] First line of Provider street address
    String nppes_provider_street_1;

    // [8] Second line of Provider street address
    String nppes_provider_street_2;

    // [9]  City of Provider street address
    String nppes_provider_city;

    // [10] Zip code of Provider street address
    Integer nppes_provider_zip;

    // [11] State postal abbreviation of Provider street address
    String nppes_provider_state;

    // [12] Country abbreviation of Provider street address
    String nppes_provider_country;

    // [13] Specialty code associated with largest number of services provided by
    // Provider.
    String provider_type;

    // [14] 'Y' signifies Provider had at least one instance of accepting medicare.
    String medicare_participation_indicator;

    // [15] 'F' represents medical facility. 'O' represents non-facility (generally
    // office setting).
    String place_of_service;

    /**
     * CONSTRUCTOR
     */

    Provider() {
        this.npi = null;
        this.nppes_provider_last_org_name = null;
        this.nppes_provider_first_name = null;
        this.nppes_provider_m_i = null;
        this.nppes_credentials = null;
        this.nppes_provider_gender = null;
        this.nppes_provider_street_1 = null;
        this.nppes_provider_street_2 = null;
        this.nppes_provider_city = null;
        this.nppes_provider_zip = null;
        this.nppes_provider_state = null;
        this.nppes_provider_country = null;
        this.provider_type = null;
        this.medicare_participation_indicator = null;
        this.place_of_service = null;
    }

    Provider(String line) {
        String[] tokens = line.split(",");
        this.npi = Long.parseLong(tokens[0]);
        this.nppes_entity_code = tokens[6];
        this.nppes_provider_gender = tokens[5];
        this.nppes_provider_state = tokens[11];
        this.provider_type = tokens[13];
    }

    Provider(Long npi, String nppes_provider_last_org_name,
             String nppes_provider_first_name, String nppes_provider_m_i,
             String nppes_credentials, String nppes_provider_gender,
             String nppes_provider_street_1, String nppes_provider_street_2,
             String nppes_provider_city, Integer nppes_provider_zip,
             String nppes_provider_state, String nppes_provider_country,
             String provider_type, String medicare_participation_indicator,
             String place_of_service) {
        this.npi = npi;
        this.nppes_provider_last_org_name = nppes_provider_last_org_name;
        this.nppes_provider_first_name = nppes_provider_first_name;
        this.nppes_provider_m_i = nppes_provider_m_i;
        this.nppes_credentials = nppes_credentials;
        this.nppes_provider_gender = nppes_provider_gender;
        this.nppes_provider_street_1 = nppes_provider_street_1;
        this.nppes_provider_street_2 = nppes_provider_street_2;
        this.nppes_provider_city = nppes_provider_city;
        this.nppes_provider_zip = nppes_provider_zip;
        this.nppes_provider_state = nppes_provider_state;
        this.nppes_provider_country = nppes_provider_country;
        this.provider_type = provider_type;
        this.medicare_participation_indicator = medicare_participation_indicator;
        this.place_of_service = place_of_service;
    }

    /**
     * METHODS
     */

    @Override
    public int compareTo(Object o) {
        if (this.getNpi() > ((Provider) o).getNpi()) {
            return 1;
        }
        if (this.getNpi() < ((Provider) o).getNpi()) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provider provider = (Provider) o;

        return npi.equals(provider.npi);
    }

    @Override
    public int hashCode() {
        return npi.hashCode();
    }

    @Override
    public String toString() {
        return npi
//                + "," + nppes_provider_last_org_name
//                + "," + nppes_provider_first_name
//                + "," + nppes_provider_m_i
//                + "," + nppes_credentials
                + "," + nppes_provider_gender
                + "," + nppes_entity_code
//                + "," + nppes_provider_street_1
//                + "," + nppes_provider_street_2
//                + "," + nppes_provider_city
//                + "," + nppes_provider_zip
                + "," + nppes_provider_state
//                + "," + nppes_provider_country
                + "," + provider_type
//                + "," + medicare_participation_indicator
//                + "," + place_of_service
                ;
    }

    /**
     * GETTERS AND SETTERS
     */

    public long getNpi() {
        return npi;
    }

    public void setNpi(long npi) {
        this.npi = npi;
    }

    public String getNppes_provider_last_org_name() {
        return nppes_provider_last_org_name;
    }

    public void setNppes_provider_last_org_name(
            String nppes_provider_last_org_name) {
        this.nppes_provider_last_org_name = nppes_provider_last_org_name;
    }

    public String getNppes_provider_first_name() {
        return nppes_provider_first_name;
    }

    public void setNppes_provider_first_name(String nppes_provider_first_name) {
        this.nppes_provider_first_name = nppes_provider_first_name;
    }

    public String getNppes_provider_m_i() {
        return nppes_provider_m_i;
    }

    public void setNppes_provider_m_i(String nppes_provider_m_i) {
        this.nppes_provider_m_i = nppes_provider_m_i;
    }

    public String getNppes_credentials() {
        return nppes_credentials;
    }

    public void setNppes_credentials(String nppes_credentials) {
        this.nppes_credentials = nppes_credentials;
    }

    public String getNppes_provider_gender() {
        return nppes_provider_gender;
    }

    public void setNppes_provider_gender(String nppes_provider_gender) {
        this.nppes_provider_gender = nppes_provider_gender;
    }

    public String getNppes_entity_code() {
        return nppes_entity_code;
    }

    public void setNppes_entity_code(String nppes_entity_code) {
        this.nppes_entity_code = nppes_entity_code;
    }

    public String getNppes_provider_street_1() {
        return nppes_provider_street_1;
    }

    public void setNppes_provider_street_1(String nppes_provider_street_1) {
        this.nppes_provider_street_1 = nppes_provider_street_1;
    }

    public String getNppes_provider_street_2() {
        return nppes_provider_street_2;
    }

    public void setNppes_provider_street_2(String nppes_provider_street_2) {
        this.nppes_provider_street_2 = nppes_provider_street_2;
    }

    public String getNppes_provider_city() {
        return nppes_provider_city;
    }

    public void setNppes_provider_city(String nppes_provider_city) {
        this.nppes_provider_city = nppes_provider_city;
    }

    public int getNppes_provider_zip() {
        return nppes_provider_zip;
    }

    public void setNppes_provider_zip(int nppes_provider_zip) {
        this.nppes_provider_zip = nppes_provider_zip;
    }

    public String getNppes_provider_state() {
        return nppes_provider_state;
    }

    public void setNppes_provider_state(String nppes_provider_state) {
        this.nppes_provider_state = nppes_provider_state;
    }

    public String getNppes_provider_country() {
        return nppes_provider_country;
    }

    public void setNppes_provider_country(String nppes_provider_country) {
        this.nppes_provider_country = nppes_provider_country;
    }

    public String getProvider_type() {
        return provider_type;
    }

    public void setProvider_type(String provider_type) {
        this.provider_type = provider_type;
    }

    public String getMedicare_participation_indicator() {
        return medicare_participation_indicator;
    }

    public void setMedicare_participation_indicator(
            String medicare_participation_indicator) {
        this.medicare_participation_indicator = medicare_participation_indicator;
    }

    public String getPlace_of_service() {
        return place_of_service;
    }

    public void setPlace_of_service(String place_of_service) {
        this.place_of_service = place_of_service;
    }

}