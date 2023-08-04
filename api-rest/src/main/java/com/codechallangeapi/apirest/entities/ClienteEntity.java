package com.codechallangeapi.apirest.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private long idCliente;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "identificacion")
	private String identificacion;
	@Column(name = "tipo_identificacion")
	private int tipoIdentifiacion;
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;

	public ClienteEntity() {
		super();
	}

	public ClienteEntity(String nombre, String identificacion, int tipoIdentifiacion, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.tipoIdentifiacion = tipoIdentifiacion;
		this.fechaNacimiento = fechaNacimiento;
	}

	public ClienteEntity(long idCliente, String nombre, String identificacion, int tipoIdentifiacion,
			LocalDate fechaNacimiento) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.tipoIdentifiacion = tipoIdentifiacion;
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long id) {
		this.idCliente = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public int getTipoIdentifiacion() {
		return tipoIdentifiacion;
	}

	public void setTipoIdentifiacion(int tipoIdentifiacion) {
		this.tipoIdentifiacion = tipoIdentifiacion;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, idCliente, identificacion, nombre, tipoIdentifiacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEntity other = (ClienteEntity) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && idCliente == other.idCliente
				&& Objects.equals(identificacion, other.identificacion) && Objects.equals(nombre, other.nombre)
				&& tipoIdentifiacion == other.tipoIdentifiacion;
	}
}
