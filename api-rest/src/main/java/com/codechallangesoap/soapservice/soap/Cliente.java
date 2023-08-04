
package com.codechallangesoap.soapservice.soap;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cliente complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="cliente">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="identificacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="tipoIdentifiacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cliente", propOrder = {
    "idCliente",
    "nombre",
    "identificacion",
    "tipoIdentifiacion",
    "fechaNacimiento"
})
public class Cliente {

    protected long idCliente;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String identificacion;
    protected int tipoIdentifiacion;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaNacimiento;

    /**
     * Gets the value of the idCliente property.
     * 
     */
    public long getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the value of the idCliente property.
     * 
     */
    public void setIdCliente(long value) {
        this.idCliente = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the identificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Sets the value of the identificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificacion(String value) {
        this.identificacion = value;
    }

    /**
     * Gets the value of the tipoIdentifiacion property.
     * 
     */
    public int getTipoIdentifiacion() {
        return tipoIdentifiacion;
    }

    /**
     * Sets the value of the tipoIdentifiacion property.
     * 
     */
    public void setTipoIdentifiacion(int value) {
        this.tipoIdentifiacion = value;
    }

    /**
     * Gets the value of the fechaNacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Sets the value of the fechaNacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaNacimiento(XMLGregorianCalendar value) {
        this.fechaNacimiento = value;
    }

}
