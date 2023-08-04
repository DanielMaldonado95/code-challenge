
package com.codechallangesoap.soapservice.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "ClientesPort", targetNamespace = "http://www.codechallange.com/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClientesPort {


    /**
     * 
     * @param actualizarClienteRequest
     * @return
     *     returns com.codechallangesoap.soapservice.soap.ActualizarClienteResponse
     */
    @WebMethod
    @WebResult(name = "actualizarClienteResponse", targetNamespace = "http://www.codechallange.com/", partName = "actualizarClienteResponse")
    public ActualizarClienteResponse actualizarCliente(
        @WebParam(name = "actualizarClienteRequest", targetNamespace = "http://www.codechallange.com/", partName = "actualizarClienteRequest")
        ActualizarClienteRequest actualizarClienteRequest);

    /**
     * 
     * @param eliminarClienteRequest
     * @return
     *     returns com.codechallangesoap.soapservice.soap.EliminarClienteResponse
     */
    @WebMethod
    @WebResult(name = "eliminarClienteResponse", targetNamespace = "http://www.codechallange.com/", partName = "eliminarClienteResponse")
    public EliminarClienteResponse eliminarCliente(
        @WebParam(name = "eliminarClienteRequest", targetNamespace = "http://www.codechallange.com/", partName = "eliminarClienteRequest")
        EliminarClienteRequest eliminarClienteRequest);

    /**
     * 
     * @param guardarClienteRequest
     * @return
     *     returns com.codechallangesoap.soapservice.soap.GuardarClienteResponse
     */
    @WebMethod
    @WebResult(name = "guardarClienteResponse", targetNamespace = "http://www.codechallange.com/", partName = "guardarClienteResponse")
    public GuardarClienteResponse guardarCliente(
        @WebParam(name = "guardarClienteRequest", targetNamespace = "http://www.codechallange.com/", partName = "guardarClienteRequest")
        GuardarClienteRequest guardarClienteRequest);

}
