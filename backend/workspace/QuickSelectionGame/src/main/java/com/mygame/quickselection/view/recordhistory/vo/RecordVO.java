package com.mygame.quickselection.view.recordhistory.vo;

import java.security.Timestamp;

import lombok.Data;

@Data
public class RecordVO {

	private Integer rank;
	private String name;
	private Integer score;
	private Timestamp createDate;
}
