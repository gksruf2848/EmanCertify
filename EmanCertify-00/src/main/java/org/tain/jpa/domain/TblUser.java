package org.tain.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_user")
@Data
public class TblUser {

	@Id
	private Long id;
	
	private String user;
	
	private String pw;
}
