
package com.codechallangesoap.soapservice.soap;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cuenta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="cuenta">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="numeroCuenta" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="fechaApartura" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         <element name="horaApertura" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         <element name="estadoCuenta" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="saldo" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="cliente" type="{http://www.codechallange.com/}cliente"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cuenta", propOrder = {
    "numeroCuenta",
    "fechaApartura",
    "horaApertura",
    "estadoCuenta",
    "saldo",
    "cliente"
})
public class Cuenta {

    protected long numeroCuenta;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaApartura;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar horaApertura;
    protected boolean estadoCuenta;
    protected double saldo;
    @XmlElement(required = true)
    protected Cliente cliente;

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
     * Gets the value of the fechaApartura property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaApartura() {
        return fechaApartura;
    }

    /**
     * Sets the value of the fechaApartura property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaApartura(XMLGregorianCalendar value) {
        this.fechaApartura = value;
    }

    /**
     * Gets the value of the horaApertura property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHoraApertura() {
        return horaApertura;
    }

    /**
     * Sets the value of the horaApertura property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHoraApertura(XMLGregorianCalendar value) {
        this.horaApertura = value;
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

    /**
     * Gets the value of the cliente property.
     * 
     * @return
     *     possible object is
     *     {@link Cliente }
     *     
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Sets the value of the cliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cliente }
     *     
     */
    public void setCliente(Cliente value) {
        this.cliente = value;
    }

}
