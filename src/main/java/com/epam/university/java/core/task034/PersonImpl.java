package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@JsonAutoDetect
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonImpl implements Person {
    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private int id;

    @JsonProperty("firstName")
    @XmlElement(name = "first-name")
    private String firstName;

    @JsonProperty("lastName")
    @XmlElement(name = "last-name")
    private String lastName;

    @JsonProperty("phones")
    @SerializedName("phones")
    @XmlElementWrapper(name = "person-phones")
    @XmlElements({@XmlElement(type = PhoneNumberImpl.class, name = "person-phone")})
    private Collection<PhoneNumber> phoneNumbers;

    public PersonImpl() {
    }

    /**
     * Constructor.
     *
     * @param id id
     * @param firstName first name
     * @param lastName last name
     * @param phoneNumbers phone numbers
     */
    @JsonCreator
    public PersonImpl(@JsonProperty(value = "id") int id,
                      @JsonProperty(value = "firstName") String firstName,
                      @JsonProperty(value = "lastName") String lastName,
                      @JsonProperty(value = "phones") Collection<PhoneNumberImpl> phoneNumbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
    }

    /**
     * Get person id.
     *
     * @return person id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Set person id.
     *
     * @param id person id
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get person first name.
     *
     * @return first name
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set person first name.
     *
     * @param firstName first name
     */
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get person last name.
     *
     * @return last name
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * Set person last name.
     *
     * @param lastName last name
     */
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get phone numbers collection.
     *
     * @return phone numbers
     */
    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Set phone numbers collection.
     *
     * @param phoneNumbers phone numbers
     */
    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
