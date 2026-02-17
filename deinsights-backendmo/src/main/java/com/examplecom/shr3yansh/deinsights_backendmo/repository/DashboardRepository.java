package com.examplecom.shr3yansh.deinsights_backendmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examplecom.shr3yansh.deinsights_backendmo.entity.DashboardRecord;
import java.util.List;

public interface DashboardRepository extends JpaRepository<DashboardRecord, Long> {

    List<DashboardRecord> findByProductType(String productType);

    List<DashboardRecord> findByStates(String states);

}