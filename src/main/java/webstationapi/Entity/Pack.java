package webstationapi.Entity;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

@Entity
@Table(name = "ECOLE_PACK")
public class Pack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int packId;

	@ManyToOne
	@JoinColumn(name = "PERIOD_ID")
	private Period period;

	@ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "PACK_TICKETS")
	@MapKeyEnumerated(EnumType.STRING)
    @Column(name="TICKET")
	private Map<DayMoment, Integer> tickets;

	@Column(name = "MOMENT")
	private DayMoment moment;

	@Column(name = "PRICE")
	private double price;

	public int getPackId() { return packId; }
	public void setPackId(int packId) { this.packId = packId; }
	public Period getPeriod() { return period; }
	public void setPeriod(Period period) { this.period = period; }
	public Map<DayMoment, Integer> getTickets() { return tickets; }
	public void setTickets(Map<DayMoment, Integer> tickets) { this.tickets = tickets; }
	public DayMoment getMoment() { return moment; }
	public void setMoment(DayMoment moment) { this.moment = moment; }
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }

}
