package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class contact implements Serializable {
	@Id
	@Column(name="contactid")
	private int contactid;
	@Column(name="fullname")
	private String fullname;
	@Column(name="image")
	private String image;
	@Column(name="dateofBirth")
	private String dateofBirth;
	@Column(name="sex")
	private String sex;
	@Column(name="address")
	private String address;
	public contact(int contactid, String fullname, String image, String dateofBirth, String sex, String address) {
		this.contactid = contactid;
		this.fullname = fullname;
		this.image = image;
		this.dateofBirth = dateofBirth;
		this.sex = sex;
		this.address = address;
	}
	public contact() {
	}
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
