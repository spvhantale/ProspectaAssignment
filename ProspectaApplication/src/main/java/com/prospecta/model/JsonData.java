package com.prospecta.model;

import java.util.List;



import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {

	private Integer count;
	
	private List<Entry> entries;
	
	
}
