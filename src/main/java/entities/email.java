package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emailcontact")
public class email implements Serializable {
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contactid")
	private contact contactid;
	@Column(name="email")
	private String email;
	
	
	public email(contact contactid, String email) {
		this.contactid = contactid;
		this.email = email;
	}
	public email() {
	}
	public contact getContactid() {
		return contactid;
	}
	public void setContactid(contact contactid) {
		this.contactid = contactid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
