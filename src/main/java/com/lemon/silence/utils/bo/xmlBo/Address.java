package com.lemon.silence.utils.bo.xmlBo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author silence
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "address")
@Data
public class Address {

    private String province;
    private String city;
}
