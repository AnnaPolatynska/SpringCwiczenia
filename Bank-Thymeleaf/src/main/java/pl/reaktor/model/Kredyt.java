package pl.reaktor.model;

public class Kredyt {

	
	private double kwota;
	private String czas;
	private double procent =0.1;
	private double rata;
	private double kwotaCalosc;
	public double getKwota() {
		return kwota;
	}
	public void setKwota(double kwota) {
		this.kwota = kwota;
	}
	public String getCzas() {
		return czas;
	}
	public void setCzas(String czas) {
		this.czas = czas;
	}
	public double getProcent() {
		return procent;
	}
	public void setProcent(double procent) {
		this.procent = procent;
	}
	public double getRata() {
		return rata;
	}
	public void setRata(double rata) {
		this.rata = rata;
	}
	public double getKwotaCalosc() {
		return kwotaCalosc;
	}
	public void setKwotaCalosc(double kwotaCalosc) {
		this.kwotaCalosc = kwotaCalosc;
	}
	
	
}
