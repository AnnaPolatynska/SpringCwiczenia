package pl.reaktor.model;
public class Credit {

	private double kwota_kredyt;
	private int l_rat;
	private double procent = 0.1;
	
	public double getKwota_kredyt() {
		return kwota_kredyt;
	}
	public void setKwota_kredyt(double kwota_kredyt) {
		this.kwota_kredyt = kwota_kredyt;
	}
	public int getL_rat() {
		return l_rat;
	}
	public void setL_rat(int l_rat) {
		this.l_rat = l_rat;
	}
	public double getProcent() {
		return procent;
	}
	public void setProcent(double procent) {
		this.procent = procent;
	}
}
