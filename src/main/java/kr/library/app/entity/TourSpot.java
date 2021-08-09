package kr.library.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "st_tour_spot")
@Getter
@Setter
@DynamicInsert
public class TourSpot {
	
	@Builder
	TourSpot(String lClass, String mClass, String sClass, String tel, String city, String town, String name, String address, String area) {
		this.lClass = lClass; 
		this.mClass = mClass; 
		this.sClass = sClass; 
		this.tel = tel; 
		this.city = city; 
		this.town = town; 
		this.name = name; 
		this.address = address; 
		this.area = area; 
		this.lClass = lClass; 
	}

	@Id
	@Column(nullable = false, columnDefinition = "INT(12) NOT NULL AUTO_INCREMENT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int seq;

	@Column(length = 300)
	String lClass;
	
	@Column(length = 300)
	String mClass;
	
	@Column(length = 300)
	String sClass;
	
	@Column(length = 100)
	String tel;
	
	@Column(length = 100)
	String city;
	
	@Column(length = 100)
	String town;
	
	@Column(length = 300)
	String name;
	
	@Column(length = 500)
	String address;
	
	@Column(length = 100)
	String area;
}
