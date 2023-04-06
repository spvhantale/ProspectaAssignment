package com.prospecta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.exception.CategoryException;
import com.prospecta.model.Entry;
import com.prospecta.model.JsonData;
import com.prospecta.model.ResultDTO;

@Service
public class MyServiceImpl implements MyService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<ResultDTO> getTitle(String category) throws CategoryException{
		
		JsonData d=restTemplate.getForObject("https://api.publicapis.org/entries", JsonData.class);
		
		List<Entry> elist=d.getEntries();
		
		List<ResultDTO> rlist=elist.stream().filter((e)->{
			String str=e.getCategory();
			
			String[] st=str.split(" ");
			
			if(str.contains("&")) {
				st=str.split(" & ");
			}
			
			if(st[0].toLowerCase().equals(category.toLowerCase())) {
					return true;
			}
			
			return false;
			
		}).map(e->(new ResultDTO(e.getApi(), e.getDescription()))).toList();

		
		if(rlist.isEmpty()) {
			throw new CategoryException("Category Not found");
		}
		
		return rlist;
	}

	@Override
	public List<Entry> saveEntry(Entry entry) {
		
		JsonData d=restTemplate.getForObject("https://api.publicapis.org/entries", JsonData.class);
		
		List<Entry> elist=d.getEntries();
		
		elist.add(entry);
		
		return elist;
	}

}
