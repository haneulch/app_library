package kr.stam.app.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "st_visited_place")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class VisitedPlace {

	public VisitedPlace(String username) {
		this.username = username;
//		this.placeSeq = placeSeq;
	}

	@Id
	@Column(nullable = false, columnDefinition = "INT(12) NOT NULL AUTO_INCREMENT")
	int seq;
	
	@Column(length = 50)
	String username;
	
//	@Column(nullable = false, length = 11)
//	int placeSeq;
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	Timestamp regDt;
	
    @OneToOne(cascade = CascadeType.ALL)
    @Nullable
    @JoinColumn(name = "placeSeq")
	Place place;
}
