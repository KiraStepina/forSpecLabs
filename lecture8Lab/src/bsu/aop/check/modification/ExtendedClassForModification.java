package bsu.aop.check.modification;

public class ExtendedClassForModification {
	
	private String OLOLO;
	private int OLOLO2;
	private double notOlolo = 0;
	public String getOLOLO() {
		return OLOLO;
	}
	public void setOLOLO(String oLOLO) {
		OLOLO = oLOLO;
	}
	public int getOLOLO2() {
		return OLOLO2;
	}
	public void setOLOLO2(int oLOLO2) {
		OLOLO2 = oLOLO2;
	}
	public double getNotOlolo() {
		return notOlolo;
	}
	public void setNotOlolo(double notOlolo) {
		System.out.println("Not modified!!!!!");
	}
	

}
