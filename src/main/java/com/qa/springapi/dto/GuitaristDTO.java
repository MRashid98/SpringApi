package com.qa.springapi.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Converting POJO (Entity) to JSON (Front-end view)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GuitaristDTO {
	
	private long id;
	private String name;
	private int noOfStrings;
	private String type;
	
	
}
