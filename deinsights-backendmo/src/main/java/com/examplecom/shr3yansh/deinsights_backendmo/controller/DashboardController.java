package com.examplecom.shr3yansh.deinsights_backendmo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.examplecom.shr3yansh.deinsights_backendmo.dto.DashboardDTO;
import com.examplecom.shr3yansh.deinsights_backendmo.entity.DashboardRecord;
import com.examplecom.shr3yansh.deinsights_backendmo.service.DashboardService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/dashboard-data")
    public List<DashboardDTO> getAllData() {
        return dashboardService.getAllRecords();
    }

    @GetMapping("/dashboard-data/paginated")
    public Page<DashboardDTO> getPaginatedData(Pageable pageable) {
        return dashboardService.getPaginatedRecords(pageable);
    }

    @GetMapping("/dashboard-data/product/{productType}")
    public List<DashboardDTO> getByProduct(@PathVariable String productType) {
        return dashboardService.getByProductType(productType);
    }

    @GetMapping("/dashboard-data/state/{state}")
    public List<DashboardDTO> getByState(@PathVariable String state) {
        return dashboardService.getByState(state);
    }

    @GetMapping("/dashboard-summary")
    public Map<String, Object> getSummary() {
        return dashboardService.getSummary();
    }

    @PostMapping("/dashboard-data")
    public DashboardRecord createRecord(@Valid @RequestBody DashboardRecord record) {
        return dashboardService.saveRecord(record);
    }

}
