//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.04 at 04:49:42 PM CST 
//


package com.codechallangesoap.soapservice.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numeroCuenta" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="estadoCuenta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numeroCuenta",
    "estadoCuenta",
    "saldo"
})
@XmlRootElement(name = "actualizarCuentaRequest")
public class ActualizarCuentaRequest {

    protected long numeroCuenta;
    protected boolean estadoCuenta;
    protected double saldo;

    /**
     * Gets the value of the numeroCuenta property.
     * 
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Sets the value of the numeroCuenta property.
     * 
     */
    public void setNumeroCuenta(long value) {
        this.numeroCuenta = value;
    }

    /**
     * Gets the value of the estadoCuenta property.
     * 
     */
    public boolean isEstadoCuenta() {
        return estadoCuenta;
    }

    /**
     * Sets the value of the estadoCuenta property.
     * 
     */
    public void setEstadoCuenta(boolean value) {
        this.estadoCuenta = value;
    }

    /**
     * Gets the value of the saldo property.
     * 
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Sets the value of the saldo property.
     * 
     */
    public void setSaldo(double value) {
        this.saldo = value;
    }

}
