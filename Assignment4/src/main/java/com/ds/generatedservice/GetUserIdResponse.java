
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
 *         &lt;element name="GetUserIdResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "getUserIdResult"
})
@XmlRootElement(name = "GetUserIdResponse")
public class GetUserIdResponse {

    @XmlElement(name = "GetUserIdResult")
    protected int getUserIdResult;

    /**
     * Gets the value of the getUserIdResult property.
     * 
     */
    public int getGetUserIdResult() {
        return getUserIdResult;
    }

    /**
     * Sets the value of the getUserIdResult property.
     * 
     */
    public void setGetUserIdResult(int value) {
        this.getUserIdResult = value;
    }

}
