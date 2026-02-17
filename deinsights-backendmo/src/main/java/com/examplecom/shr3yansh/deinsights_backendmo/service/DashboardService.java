package com.examplecom.shr3yansh.deinsights_backendmo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.examplecom.shr3yansh.deinsights_backendmo.dto.DashboardDTO;
import com.examplecom.shr3yansh.deinsights_backendmo.entity.DashboardRecord;
import com.examplecom.shr3yansh.deinsights_backendmo.exception.ResourceNotFoundException;
import com.examplecom.shr3yansh.deinsights_backendmo.repository.DashboardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final DashboardRepository repository;

    public List<DashboardDTO> getAllRecords() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<DashboardDTO> getPaginatedRecords(Pageable pageable) {
        return repository.findAll(pageable)
                .map(this::convertToDTO);
    }

    public List<DashboardDTO> getByProductType(String productType) {

        List<DashboardRecord> records = repository.findByProductType(productType);

        if (records.isEmpty()) {
            throw new ResourceNotFoundException("No records found for product: " + productType);
        }

        return records.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<DashboardDTO> getByState(String state) {
        return repository.findByStates(state)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Map<String, Object> getSummary() {
        Map<String, Object> summary = new HashMap<>();

        summary.put("totalRecords", repository.count());

        summary.put("totalApiCalls",
                repository.findAll()
                        .stream()
                        .mapToInt(DashboardRecord::getNumberOfApiCalls)
                        .sum());

        return summary;
    }

    public DashboardRecord saveRecord(DashboardRecord record) {
        return repository.save(record);
    }

    private DashboardDTO convertToDTO(DashboardRecord record) {
        return new DashboardDTO(
                record.getAccountNumber(),
                record.getAge(),
                record.getCompanyName(),
                record.getProductType(),
                record.getStates(),
                record.getSizeOfCompany(),
                record.getNumberOfApiCalls());
    }
}
