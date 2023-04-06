package com.prospecta.service;

import java.util.List;

import com.prospecta.exception.CategoryException;
import com.prospecta.model.Entry;
import com.prospecta.model.ResultDTO;

public interface MyService {

	public List<ResultDTO> getTitle(String category) throws CategoryException;
	
	public List<Entry> saveEntry(Entry entry);
	
}
