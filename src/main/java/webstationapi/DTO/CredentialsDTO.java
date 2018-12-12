package webstationapi.DTO;

import webstationapi.Entity.User;

public class CredentialsDTO {

    private String email;
    private String password;

    public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
    
    public User toUser() {
        User user = new User();
        user.setEmailAddress(getEmail());
        user.setPassword(getPassword());
        return user;
    }

}
