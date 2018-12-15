package webstationapi.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Cart implements Serializable {

	public Cart() {
		this.flatIds = new ArrayList<>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User user;

	@ElementCollection
	private Collection<Integer> flatIds;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Integer> getFlatIds() { return flatIds; }
	public void setFlatIds(Collection<Integer> flatIds) { this.flatIds = flatIds; }
	public void addFlatId(Integer id){this.flatIds.add(id);}
}
