
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
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="numeroCuenta" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="estadoCuenta" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="saldo" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
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
