package com.lemon.silence.utils.bo.xmlBo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author silence
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "User")
@Data
public class User {

    @XmlAttribute(name = "userId")
    private String userId;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "address")
    private Address address;
    @XmlElement(name = "hobby")
    @XmlElementWrapper(name = "hobbyList")
    private List<Hobby> hobbyList;
}