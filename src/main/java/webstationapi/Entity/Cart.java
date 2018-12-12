package webstationapi.Entity;

import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class Cart {

	private Collection<Integer> flatIds;

	public Collection<Integer> getFlatIds() { return flatIds; }
	public void setFlatIds(Collection<Integer> flatIds) { this.flatIds = flatIds; }
	
}
