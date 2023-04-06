package com.prospecta.exception;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyError {

	private LocalTime localTime;
	private String message;
	private String description;
	
}
