package kr.library.app.entity;

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
@Table(name = "st_category")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

	@Id
	@Column(nullable = false, columnDefinition = "INT(12) NOT NULL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int seq;
	
	@Column(length = 300)
	String cateName;
}