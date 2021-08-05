package kr.stam.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "st_user")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	@Id
	@Column(nullable = false, columnDefinition = "INT(12) NOT NULL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int seq;
	
	@Column(nullable = false, length = 100)
	String username;
	
	@Column(nullable = false, length = 255)
	String password;
	
	@Column(nullable = false, length = 255)
	String nickname;
	
	@Column(length = 255)
	String email;
	
	@Column(nullable = false, columnDefinition = "CHAR(1) NOT NULL DEFAULT 'Y'")
	Character enabled;
	
	@Column(length = 1)
	int badPassCnt;

	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	Timestamp createdDt;
	
	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	Timestamp lastLoginDt;
}
