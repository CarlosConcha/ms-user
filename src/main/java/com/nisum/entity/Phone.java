package com.nisum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;


@Entity
@Table(name = "BNS_PHONE")
@Getter
@Builder
public class Phone {


	@Id
	@Column(name = "PHO_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "PHO_NUMBER")
	private String number;
	@Column(name = "PHO_COUNTRY_CODE")
	private String countryCode;
	@Column(name = "PHO_CITY_CODE")
	private String cityCode;
	
	@ManyToOne
	@JoinColumn(name = "usr_id")
	private User user;
}
