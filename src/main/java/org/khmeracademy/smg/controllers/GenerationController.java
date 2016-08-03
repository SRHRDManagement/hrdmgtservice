package org.khmeracademy.smg.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.model.Generation;
import org.khmeracademy.smg.services.GenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/generation")
public class GenerationController {
	
	@Autowired
	private GenerationService generationService;
	
	@RequestMapping( method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addGeneration(@RequestBody Generation generation){
		Map<String, Object> map=new HashMap<>();
		try {
			if(generationService.addGeneration(generation)){
				map.put("MESSAGE", "Inserted xxxx successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Inserted xnxx Unsuccessfully!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error! hasha love vvvvv");
			map.put("STATUS", false);
			e.printStackTrace();
			e.printStackTrace();
			e.printStackTrace();
			
			
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{gen_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getGenerationById(@PathVariable int gen_id){
		Map<String, Object> map=new HashMap<>();
		Generation byId = generationService.getGenerationById(gen_id);
		try {
			if(byId!=null){
				map.put("DATA", byId);
				map.put("MESSAGE", "Data id("+gen_id+") found successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Data not found Unsuccessfully!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getGeneration(){
		Map<String, Object> map=new HashMap<>();
		ArrayList<Generation> list = generationService.getGeneration();
		try {
			if(!list.isEmpty()){
				map.put("DATA", list);
				map.put("MESSAGE", "Data found successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Data not found Unsuccessfully!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateGeneration(@RequestBody Generation generation){
		Map<String, Object> map=new HashMap<>();
		try {
			if(generationService.updateGeneration(generation)){
				map.put("MESSAGE", "Updated successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Update Unsuccessfully!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> disabledGeneration(@RequestBody Generation generation){
		Map<String, Object> map=new HashMap<>();
		try {
			if(generationService.disabledGeneration(generation)){
				map.put("MESSAGE", "disable generation successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "disable generation Unsuccessfully!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
}
