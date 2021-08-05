package kr.stam.app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "st_report")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Report {

	@Id
	@Column(nullable = false, columnDefinition = "INT(12) NOT NULL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int seq;

	@ManyToOne
	@JoinColumn(name = "SHARE_SEQ", referencedColumnName = "SEQ")
	ShareInfo shareInfo;
	
	@Column(length = 300)
	String reason;

	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	Timestamp createdDt;
}
