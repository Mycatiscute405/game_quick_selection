package com.mygame.quickselection.view.recordhistory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mygame.quickselection.core.repository.RecordHistoryRepositorye;
import com.mygame.quickselection.core.repository.entity.RecordHistory;
import com.mygame.quickselection.view.recordhistory.service.RecordService;
import com.mygame.quickselection.view.recordhistory.vo.RecordVO;

@Service
public class RecordServiceImpl implements RecordService {

	private final RecordHistoryRepositorye repository;

	public RecordServiceImpl(RecordHistoryRepositorye repository) {
		this.repository = repository;
	}

	@Override
	public List<RecordVO> findAllRecord() {
		List<RecordHistory> list = repository.findAll();
		
		List<RecordVO> result = new ArrayList<>();
		for (int idx = 0; idx < list.size(); idx++) {
			RecordHistory rh = list.get(idx);
			RecordVO vo = new RecordVO();
			
			vo.setName(rh.getName());
			vo.setScore(rh.getScore());
			
			result.add(vo);
		}
		return result;
	}

}
