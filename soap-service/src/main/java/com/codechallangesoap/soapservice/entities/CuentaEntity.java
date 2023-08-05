package com.codechallangesoap.soapservice.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class CuentaEntity {
	@Id
	@Column(name = "numero_cuenta")
	private long numeroCuenta;
	@Column(name = "fecha_apertura")
	private LocalDate fechaApartura;
	@Column(name = "hora_apertura")
	private LocalTime horaApertura;
	@Column(name = "estado_cuenta")
	private boolean estadoCuenta;
	@Column(name = "saldo")
	private double saldo;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteEntity clienteEntity;

	public CuentaEntity() {
		super();
	}

	public CuentaEntity(long numeroCuenta, LocalDate fechaApartura, LocalTime horaApertura, boolean estadoCuenta,
			double saldo, ClienteEntity clienteEntity) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.fechaApartura = fechaApartura;
		this.horaApertura = horaApertura;
		this.estadoCuenta = estadoCuenta;
		this.saldo = saldo;
		this.clienteEntity = clienteEntity;
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public LocalDate getFechaApartura() {
		return fechaApartura;
	}

	public void setFechaApartura(LocalDate fechaApartura) {
		this.fechaApartura = fechaApartura;
	}

	public LocalTime getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(LocalTime horaApertura) {
		this.horaApertura = horaApertura;
	}

	public boolean isEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ClienteEntity getClienteEntity() {
		return clienteEntity;
	}

	public void setClienteEntity(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteEntity, estadoCuenta, fechaApartura, horaApertura, numeroCuenta, saldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaEntity other = (CuentaEntity) obj;
		return Objects.equals(clienteEntity, other.clienteEntity) && estadoCuenta == other.estadoCuenta
				&& Objects.equals(fechaApartura, other.fechaApartura)
				&& Objects.equals(horaApertura, other.horaApertura) && Objects.equals(numeroCuenta, other.numeroCuenta)
				&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo);
	}

}
