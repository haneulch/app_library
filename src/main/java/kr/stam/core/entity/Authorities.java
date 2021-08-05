package kr.stam.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="st_authorities")
@Getter
@Setter
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class Authorities {
	
	@Id
	@Column(nullable = false, length = 50)
	String username;
	
	@Column(nullable = false, length = 50)
	String authority;
}
