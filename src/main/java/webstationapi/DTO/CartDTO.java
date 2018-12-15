package webstationapi.DTO;

import java.util.Collection;

import webstationapi.Entity.Cart;
import webstationapi.Entity.Flat;

public class CartDTO {

	private int userid;
	
	private Collection<Flat> flats;
	
	public Collection<Flat> getFlats() { return flats; }
	public void setFlats(Collection<Flat> flats) { this.flats = flats; }

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
