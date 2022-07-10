package com.mygame.quickselection.view.recordhistory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mygame.quickselection.core.repository.RecordHistoryRepositorye;
import com.mygame.quickselection.view.recordhistory.service.RecordService;
import com.mygame.quickselection.view.recordhistory.vo.RecordVO;

@Controller
@RestController
@RequestMapping("api/record")
@CrossOrigin
public class RecordController {

	private final RecordService service;

	public RecordController(RecordService service) {
		this.service= service;
	}
	
	@GetMapping
	public List<RecordVO> findAllRecord(){
		return service.findAllRecord();
	}

}
