package webstationapi.Entity;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String emailAddress;

    private String password;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private Token token;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @JsonIgnore
    private Collection<Role> roles = new ArrayList<Role>() {
		private static final long serialVersionUID = -3328919039745373393L;
		{ add(Role.ROLE_USER); }
    };
    
    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Cart cart;

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getEmailAddress() { return emailAddress; }
	public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public Token getToken() { return token; }
	public void setToken(Token token) { this.token = token; }
	public Collection<Role> getRoles() { return roles; }
	public void setRoles(Collection<Role> roles) { this.roles = roles; }
	
}
