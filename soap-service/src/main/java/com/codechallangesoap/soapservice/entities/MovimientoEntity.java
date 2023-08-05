package com.codechallangesoap.soapservice.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientos")
public class MovimientoEntity {
	@Id
	@Column(name = "numero_referencia")
	private long numeroReferencia;
	@ManyToOne
	@JoinColumn(referencedColumnName = "numero_cuenta", name = "cuenta_origen")
	private CuentaEntity cuentaOrigen;
	@ManyToOne
	@JoinColumn(referencedColumnName = "numero_cuenta", name = "cuenta_destino")
	private CuentaEntity cuentaDestino;
	@Column(name = "fecha_movimiento")
	private LocalDate fechaMovimiento;
	@Column(name = "hora_movimiento")
	private LocalTime horaMovimiento;
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	@Column(name = "monto")
	private double monto;

	public MovimientoEntity() {
		super();
	}

	public MovimientoEntity(long numeroReferencia, CuentaEntity cuentaOrigen, CuentaEntity cuentaDestino,
			LocalDate fechaMovimiento, LocalTime horaMovimiento, String tipoMovimiento, double monto) {
		super();
		this.numeroReferencia = numeroReferencia;
		this.cuentaOrigen = cuentaOrigen;
		this.cuentaDestino = cuentaDestino;
		this.fechaMovimiento = fechaMovimiento;
		this.horaMovimiento = horaMovimiento;
		this.tipoMovimiento = tipoMovimiento;
		this.monto = monto;
	}

	public long getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(long numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	public CuentaEntity getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(CuentaEntity cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public CuentaEntity getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(CuentaEntity cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public LocalDate getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(LocalDate fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public LocalTime getHoraMovimiento() {
		return horaMovimiento;
	}

	public void setHoraMovimiento(LocalTime horaMovimiento) {
		this.horaMovimiento = horaMovimiento;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuentaDestino, cuentaOrigen, fechaMovimiento, horaMovimiento, monto, numeroReferencia,
				tipoMovimiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimientoEntity other = (MovimientoEntity) obj;
		return Objects.equals(cuentaDestino, other.cuentaDestino) && Objects.equals(cuentaOrigen, other.cuentaOrigen)
				&& Objects.equals(fechaMovimiento, other.fechaMovimiento)
				&& Objects.equals(horaMovimiento, other.horaMovimiento)
				&& Double.doubleToLongBits(monto) == Double.doubleToLongBits(other.monto)
				&& numeroReferencia == other.numeroReferencia && Objects.equals(tipoMovimiento, other.tipoMovimiento);
	}

}
