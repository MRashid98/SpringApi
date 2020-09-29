package com.qa.springapi.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Guitarist {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "guitarist_name", unique = false)
	@NotNull
	@Size(min = 1, max = 120)
	private String name;

	@Column(name = "strings")
	@Min(4)
	@Max(12)
	private int noofString;

	@Column(name = "type")
	@NotNull
	private String type;
	
	@ManyToOne(targetEntity = Band.class)
	private Band band;

	public Guitarist(@NotNull @Size(min = 1, max = 120) String name, @Min(4) @Max(12) int noofString,
			@NotNull String type) {
		super();
		this.name = name;
		this.noofString = noofString;
		this.type = type;
	}

}
