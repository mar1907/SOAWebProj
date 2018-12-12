
package com.ds.generatedservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LogInResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "logInResult"
})
@XmlRootElement(name = "LogInResponse")
public class LogInResponse {

    @XmlElement(name = "LogInResult")
    protected int logInResult;

    /**
     * Gets the value of the logInResult property.
     * 
     */
    public int getLogInResult() {
        return logInResult;
    }

    /**
     * Sets the value of the logInResult property.
     * 
     */
    public void setLogInResult(int value) {
        this.logInResult = value;
    }

}
