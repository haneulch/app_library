package kr.stam.app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "st_file")
@Getter
@Setter
@DynamicInsert
public class FileTest {

	@Id
	@Column(nullable = false, columnDefinition = "INT(12) NOT NULL AUTO_INCREMENT")
	int seq;

	@Column(length = 100)
	String fileName;

	@Column(length = 100)
	String orgFileName;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	Timestamp regDt;

	@Column(length = 50)
	String regUser;

	@Builder
	public FileTest(String fileName, String orgFileName, String regUser) {
		this.fileName = fileName;
		this.orgFileName = orgFileName;
		this.regUser = regUser;
	}
}