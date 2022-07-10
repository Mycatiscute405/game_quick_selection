package com.mygame.quickselection.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mygame.quickselection.core.repository.entity.RecordHistory;
import com.mygame.quickselection.core.repository.entity.id.RecordHistoryId;

public interface RecordHistoryRepositorye extends JpaRepository<RecordHistory, RecordHistoryId>{

}
