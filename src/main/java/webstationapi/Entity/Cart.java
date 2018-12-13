package webstationapi.Entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Cart implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User user;

	@ElementCollection
	private Collection<Integer> flatIds;

	public Collection<Integer> getFlatIds() { return flatIds; }
	public void setFlatIds(Collection<Integer> flatIds) { this.flatIds = flatIds; }

}
