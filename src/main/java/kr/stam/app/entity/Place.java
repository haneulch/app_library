package kr.stam.app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "st_place")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class Place {
	
	public Place(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public Place(int seq) {
		this.seq = seq;
	}

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int seq;
	
	@Column
	String name;
	
	@Column
	String address;
	
	@CreationTimestamp
	Timestamp regDt;
	
	@UpdateTimestamp
	Timestamp udtDt;
	
//	@OneToMany
//	@Nullable
//	@JoinColumn(referencedColumnName = "place_seq", insertable = false, updatable = false, nullable = true)
//	VisitedPlace visitedPlace;
	
}
