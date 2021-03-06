
package com.ds.generatedservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ClientServiceSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClientServiceSoap {


    /**
     * 
     * @param password
     * @param name
     * @return
     *     returns int
     */
    @WebMethod(operationName = "LogIn", action = "http://tempuri.org/LogIn")
    @WebResult(name = "LogInResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "LogIn", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.LogIn")
    @ResponseWrapper(localName = "LogInResponse", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.LogInResponse")
    public int logIn(
        @WebParam(name = "name", targetNamespace = "http://tempuri.org/")
        String name,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        String password);

    /**
     * 
     * @param password
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Register", action = "http://tempuri.org/Register")
    @WebResult(name = "RegisterResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Register", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.Register")
    @ResponseWrapper(localName = "RegisterResponse", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.RegisterResponse")
    public String register(
        @WebParam(name = "name", targetNamespace = "http://tempuri.org/")
        String name,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        String password);

    /**
     * 
     * @param userId
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetPackages", action = "http://tempuri.org/GetPackages")
    @WebResult(name = "GetPackagesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetPackages", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.GetPackages")
    @ResponseWrapper(localName = "GetPackagesResponse", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.GetPackagesResponse")
    public String getPackages(
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        int userId);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "SearchPackage", action = "http://tempuri.org/SearchPackage")
    @WebResult(name = "SearchPackageResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SearchPackage", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.SearchPackage")
    @ResponseWrapper(localName = "SearchPackageResponse", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.SearchPackageResponse")
    public String searchPackage(
        @WebParam(name = "name", targetNamespace = "http://tempuri.org/")
        String name);

    /**
     * 
     * @param packId
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetTracking", action = "http://tempuri.org/GetTracking")
    @WebResult(name = "GetTrackingResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetTracking", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.GetTracking")
    @ResponseWrapper(localName = "GetTrackingResponse", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.GetTrackingResponse")
    public String getTracking(
        @WebParam(name = "packId", targetNamespace = "http://tempuri.org/")
        int packId);

    /**
     * 
     * @param pass
     * @param name
     * @return
     *     returns int
     */
    @WebMethod(operationName = "GetUserId", action = "http://tempuri.org/GetUserId")
    @WebResult(name = "GetUserIdResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetUserId", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.GetUserId")
    @ResponseWrapper(localName = "GetUserIdResponse", targetNamespace = "http://tempuri.org/", className = "com.ds.generatedservice.GetUserIdResponse")
    public int getUserId(
        @WebParam(name = "name", targetNamespace = "http://tempuri.org/")
        String name,
        @WebParam(name = "pass", targetNamespace = "http://tempuri.org/")
        String pass);

}
