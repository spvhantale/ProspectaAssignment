package com.prospecta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {

	@JsonProperty("Title")
	private String title;
	@JsonProperty("Description")
	private String description;
	
}
