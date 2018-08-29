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
@Table(name="phonecontact")
public class phone implements Serializable {
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contactid")
	private contact contactid;
	@Column(name="phone")
	private String phone;
	public phone(contact contactid, String phone) {
		this.contactid = contactid;
		this.phone = phone;
	}
	public phone() {
	}
	public contact getContactid() {
		return contactid;
	}
	public void setContactid(contact contactid) {
		this.contactid = contactid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	
}
