<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempuri.org/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" targetNamespace="http://tempuri.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
      <s:element name="LogIn">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="name" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="LogInResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="LogInResult" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Register">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="name" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="RegisterResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="RegisterResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetPackages">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="userId" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetPackagesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetPackagesResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SearchPackage">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="name" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SearchPackageResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SearchPackageResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTracking">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="packId" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTrackingResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetTrackingResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetUserId">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="name" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pass" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetUserIdResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="GetUserIdResult" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="LogInSoapIn">
    <wsdl:part name="parameters" element="tns:LogIn" />
  </wsdl:message>
  <wsdl:message name="LogInSoapOut">
    <wsdl:part name="parameters" element="tns:LogInResponse" />
  </wsdl:message>
  <wsdl:message name="RegisterSoapIn">
    <wsdl:part name="parameters" element="tns:Register" />
  </wsdl:message>
  <wsdl:message name="RegisterSoapOut">
    <wsdl:part name="parameters" element="tns:RegisterResponse" />
  </wsdl:message>
  <wsdl:message name="GetPackagesSoapIn">
    <wsdl:part name="parameters" element="tns:GetPackages" />
  </wsdl:message>
  <wsdl:message name="GetPackagesSoapOut">
    <wsdl:part name="parameters" element="tns:GetPackagesResponse" />
  </wsdl:message>
  <wsdl:message name="SearchPackageSoapIn">
    <wsdl:part name="parameters" element="tns:SearchPackage" />
  </wsdl:message>
  <wsdl:message name="SearchPackageSoapOut">
    <wsdl:part name="parameters" element="tns:SearchPackageResponse" />
  </wsdl:message>
  <wsdl:message name="GetTrackingSoapIn">
    <wsdl:part name="parameters" element="tns:GetTracking" />
  </wsdl:message>
  <wsdl:message name="GetTrackingSoapOut">
    <wsdl:part name="parameters" element="tns:GetTrackingResponse" />
  </wsdl:message>
  <wsdl:message name="GetUserIdSoapIn">
    <wsdl:part name="parameters" element="tns:GetUserId" />
  </wsdl:message>
  <wsdl:message name="GetUserIdSoapOut">
    <wsdl:part name="parameters" element="tns:GetUserIdResponse" />
  </wsdl:message>
  <wsdl:portType name="ClientServiceSoap">
    <wsdl:operation name="LogIn">
      <wsdl:input message="tns:LogInSoapIn" />
      <wsdl:output message="tns:LogInSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Register">
      <wsdl:input message="tns:RegisterSoapIn" />
      <wsdl:output message="tns:RegisterSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPackages">
      <wsdl:input message="tns:GetPackagesSoapIn" />
      <wsdl:output message="tns:GetPackagesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SearchPackage">
      <wsdl:input message="tns:SearchPackageSoapIn" />
      <wsdl:output message="tns:SearchPackageSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTracking">
      <wsdl:input message="tns:GetTrackingSoapIn" />
      <wsdl:output message="tns:GetTrackingSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetUserId">
      <wsdl:input message="tns:GetUserIdSoapIn" />
      <wsdl:output message="tns:GetUserIdSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="ClientServiceSoap" type="tns:ClientServiceSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="LogIn">
      <soap:operation soapAction="http://tempuri.org/LogIn" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Register">
      <soap:operation soapAction="http://tempuri.org/Register" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPackages">
      <soap:operation soapAction="http://tempuri.org/GetPackages" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SearchPackage">
      <soap:operation soapAction="http://tempuri.org/SearchPackage" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTracking">
      <soap:operation soapAction="http://tempuri.org/GetTracking" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetUserId">
      <soap:operation soapAction="http://tempuri.org/GetUserId" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="ClientServiceSoap12" type="tns:ClientServiceSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="LogIn">
      <soap12:operation soapAction="http://tempuri.org/LogIn" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Register">
      <soap12:operation soapAction="http://tempuri.org/Register" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPackages">
      <soap12:operation soapAction="http://tempuri.org/GetPackages" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SearchPackage">
      <soap12:operation soapAction="http://tempuri.org/SearchPackage" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTracking">
      <soap12:operation soapAction="http://tempuri.org/GetTracking" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetUserId">
      <soap12:operation soapAction="http://tempuri.org/GetUserId" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="ClientService">
    <wsdl:port name="ClientServiceSoap" binding="tns:ClientServiceSoap">
      <soap:address location="http://localhost:53675/ClientService.asmx" />
    </wsdl:port>
    <wsdl:port name="ClientServiceSoap12" binding="tns:ClientServiceSoap12">
      <soap12:address location="http://localhost:53675/ClientService.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>