package com.mygame.quickselection.core.repository.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mygame.quickselection.core.repository.entity.id.RecordHistoryId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RECORD_HST")
public class RecordHistory {

	@EmbeddedId
	RecordHistoryId id;

	@JsonProperty("name")
	@Column(name = "NAME", length = 20, nullable = true)
	private String name;

	@JsonProperty("score")
	@Column(name = "SCORE", length = 3, nullable = true)
	private Integer score;

	@JsonProperty("createDate")
	@Column(name = "CRT_DT", length = 20, nullable = true )
	private String createDate;

}
