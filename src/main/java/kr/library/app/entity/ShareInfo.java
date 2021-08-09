package kr.library.app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import kr.library.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "st_share_info")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ShareInfo {

	@Id
	@Column(nullable = false, columnDefinition = "INT(12) NOT NULL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int seq;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BOOK_SEQ", referencedColumnName = "SEQ")
	BookInfo bookInfo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_SEQ", referencedColumnName = "SEQ")
	User user;

	@Column(length = 300)
	String title;

	@Column(length = 10)
	int price;

	@Column
	String content;

	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	Timestamp createdDt;
	
	@Column(columnDefinition = "DATETIME")
	Timestamp updatedDt;
}
