package com.mygame.quickselection.core.repository.entity.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RecordHistoryId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8619162323659348964L;
	
	@JsonProperty("id")
	@Column(name="ID", length = 20, nullable = false)
	private String id;
	
}
