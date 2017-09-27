package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinitionImpl;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ilya on 24.09.17.
 */
@XmlRootElement(name = "property")
public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {

    private String name;
    private String value;
    private String ref;
    @XmlElement(type = ListDefinitionImpl.class)
    private StructureDefinition structureDefinition;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getRef() {
        return ref;
    }

    @Override
    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public StructureDefinition getData() {
        return structureDefinition;
    }

    @Override
    public void setData(StructureDefinition data) {
        this.structureDefinition = data;
    }
}