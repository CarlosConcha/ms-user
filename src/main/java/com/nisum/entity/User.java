package com.nisum.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BNS_USER")
@Getter
@Builder
public class User{

	@Id
	@Column(name = "USR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "USR_KEY")
	private String key;
	@Column(name = "USR_NAME")
	private String name;
	@Column(name = "USR_MAIL")
	private String mail;
	@Column(name = "USR_PASSWORD")
	private String password;
	@Column(name = "USR_TOKEN")
	private String token;
	@Column(name = "USR_CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDateTime creadtedDate;
	@Column(name = "USR_UPDATE_DATE")
	private LocalDateTime updatedDate;
	@Column(name = "USR_ACTIVE")
	private Boolean isActive;
	@Column(name = "USR_LAST_LOGIN")
	@CreationTimestamp
	private LocalDateTime lastLogin;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
	@Setter
	private List<Phone> phones;
}
