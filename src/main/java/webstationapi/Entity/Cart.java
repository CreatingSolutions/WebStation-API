package webstationapi.Entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@Column(name="userId")
	private int userId;
	private Collection<Integer> flatIds;

	public Collection<Integer> getFlatIds() { return flatIds; }
	public void setFlatIds(Collection<Integer> flatIds) { this.flatIds = flatIds; }
	
}
