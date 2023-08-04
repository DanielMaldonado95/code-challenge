
package com.codechallangesoap.soapservice.soap;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codechallangesoap.soapservice.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codechallangesoap.soapservice.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GuardarClienteRequest }
     * 
     * @return
     *     the new instance of {@link GuardarClienteRequest }
     */
    public GuardarClienteRequest createGuardarClienteRequest() {
        return new GuardarClienteRequest();
    }

    /**
     * Create an instance of {@link GuardarClienteResponse }
     * 
     * @return
     *     the new instance of {@link GuardarClienteResponse }
     */
    public GuardarClienteResponse createGuardarClienteResponse() {
        return new GuardarClienteResponse();
    }

    /**
     * Create an instance of {@link Estado }
     * 
     * @return
     *     the new instance of {@link Estado }
     */
    public Estado createEstado() {
        return new Estado();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     * @return
     *     the new instance of {@link Cliente }
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link ActualizarClienteRequest }
     * 
     * @return
     *     the new instance of {@link ActualizarClienteRequest }
     */
    public ActualizarClienteRequest createActualizarClienteRequest() {
        return new ActualizarClienteRequest();
    }

    /**
     * Create an instance of {@link ActualizarClienteResponse }
     * 
     * @return
     *     the new instance of {@link ActualizarClienteResponse }
     */
    public ActualizarClienteResponse createActualizarClienteResponse() {
        return new ActualizarClienteResponse();
    }

    /**
     * Create an instance of {@link EliminarClienteRequest }
     * 
     * @return
     *     the new instance of {@link EliminarClienteRequest }
     */
    public EliminarClienteRequest createEliminarClienteRequest() {
        return new EliminarClienteRequest();
    }

    /**
     * Create an instance of {@link EliminarClienteResponse }
     * 
     * @return
     *     the new instance of {@link EliminarClienteResponse }
     */
    public EliminarClienteResponse createEliminarClienteResponse() {
        return new EliminarClienteResponse();
    }

}
