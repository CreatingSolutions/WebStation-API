package webstationapi.DTO;

import java.util.Map;

import webstationapi.Entity.DayMoment;
import webstationapi.Entity.Pack;
import webstationapi.Entity.Period;

public class PackDTO {

	private int packId;
	private Period period;
	private Map<DayMoment, Integer> tickets;
	private double price;
	private boolean available;

	public PackDTO(Pack pack) {
		this.packId = pack.getPackId();
		this.period = pack.getPeriod();
		this.tickets = pack.getTickets();
		this.price = pack.getPrice();
	}

	public int getPackId() { return packId; }
	public void setPackId(int packId) { this.packId = packId; }
	public Period getPeriod() { return period; }
	public void setPeriod(Period period) { this.period = period; }
	public Map<DayMoment, Integer> getTickets() { return tickets; }
	public void setTickets(Map<DayMoment, Integer> tickets) { this.tickets = tickets; }
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }
	public boolean getAvailable() { return available; }
	public void setAvailable(boolean available) { this.available = available; }

}
