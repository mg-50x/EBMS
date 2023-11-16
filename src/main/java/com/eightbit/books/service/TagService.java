package com.eightbit.books.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightbit.books.entity.Tag_master;
import com.eightbit.books.model.Tag;
import com.eightbit.books.repository.Tag_masterRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TagService {

	@Autowired
	private Tag_masterRepository tag_masterRepo;
	
	
	/**
	 * 文字列のjsonデータを受け取り、Listにして返却する
	 * @param jsonTags
	 * @return
	 */
	public List<Tag_master> getTagListFromJson(String jsonTags){
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {node = mapper.readTree(jsonTags);} 
		catch (JsonMappingException e) {e.printStackTrace();} 
		catch (JsonProcessingException e) {	e.printStackTrace();	}
		JsonNode tagIdArray = node.get("tags");
		List<Tag_master> list = (List<Tag_master>) StreamSupport.stream(tagIdArray.spliterator(), false).map(t -> {
			return tag_masterRepo.findByTagId(t.asInt());
		}).toList();
		return list;
	}
}
