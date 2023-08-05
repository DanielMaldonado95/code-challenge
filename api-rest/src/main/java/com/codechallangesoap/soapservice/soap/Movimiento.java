
package com.codechallangesoap.soapservice.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for movimiento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="movimiento">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="numeroReferencia" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="cuentaOrigen" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="cuentaDestino" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="tipoMovimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="monto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movimiento", propOrder = {
    "numeroReferencia",
    "cuentaOrigen",
    "cuentaDestino",
    "tipoMovimiento",
    "monto"
})
public class Movimiento {

    protected long numeroReferencia;
    protected long cuentaOrigen;
    protected long cuentaDestino;
    @XmlElement(required = true)
    protected String tipoMovimiento;
    protected double monto;

    /**
     * Gets the value of the numeroReferencia property.
     * 
     */
    public long getNumeroReferencia() {
        return numeroReferencia;
    }

    /**
     * Sets the value of the numeroReferencia property.
     * 
     */
    public void setNumeroReferencia(long value) {
        this.numeroReferencia = value;
    }

    /**
     * Gets the value of the cuentaOrigen property.
     * 
     */
    public long getCuentaOrigen() {
        return cuentaOrigen;
    }

    /**
     * Sets the value of the cuentaOrigen property.
     * 
     */
    public void setCuentaOrigen(long value) {
        this.cuentaOrigen = value;
    }

    /**
     * Gets the value of the cuentaDestino property.
     * 
     */
    public long getCuentaDestino() {
        return cuentaDestino;
    }

    /**
     * Sets the value of the cuentaDestino property.
     * 
     */
    public void setCuentaDestino(long value) {
        this.cuentaDestino = value;
    }

    /**
     * Gets the value of the tipoMovimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Sets the value of the tipoMovimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoMovimiento(String value) {
        this.tipoMovimiento = value;
    }

    /**
     * Gets the value of the monto property.
     * 
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     */
    public void setMonto(double value) {
        this.monto = value;
    }

}
