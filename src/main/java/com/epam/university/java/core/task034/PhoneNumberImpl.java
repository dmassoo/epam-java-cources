package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@JsonAutoDetect
@XmlRootElement(name = "person-phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberImpl implements PhoneNumber {
    @JsonValue
    @XmlValue
    private String phoneNumber;

    /**
     * Default constructor.
     *
     */
    public PhoneNumberImpl() {}

    /**
     * Constructor.
     *
     * @param phoneNumber number
     */
    public PhoneNumberImpl(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get phone number value.
     *
     * @return number value
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phone number value.
     *
     * @param phoneNumber number value
     */
    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
