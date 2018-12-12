package webstationapi.DTO;

import java.util.Collection;

import webstationapi.Entity.Flat;

public class CartDTO {
	
	private Collection<Flat> flats;
	
	public Collection<Flat> getFlats() { return flats; }
	public void setFlats(Collection<Flat> flats) { this.flats = flats; }

}
