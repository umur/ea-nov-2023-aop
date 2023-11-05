package com.miu.lab4aop.service.impl;

import com.miu.lab4aop.common.Converter;
import com.miu.lab4aop.dto.ActivityLogDto;
import com.miu.lab4aop.entity.ActivityLog;
import com.miu.lab4aop.exceptions.ResourceNotFoundException;
import com.miu.lab4aop.repository.ActivityLogRepository;
import com.miu.lab4aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository repository;
    private final Converter converter;
    @Override
    public ActivityLogDto createActivityLog(ActivityLogDto activityLog) {
        return Optional.ofNullable(activityLog)
                .map(log-> {
                    ActivityLog entity = converter.convert(log, ActivityLog.class);
                    return converter.convert(repository.save(entity), ActivityLogDto.class);
                }).
                orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public ActivityLogDto updateActivityLog(ActivityLogDto activityLog, Long id) {
        return Optional.ofNullable(id)
                .map(entityId -> {
                    boolean exists = repository.existsById(entityId);
                    if (!exists) {
                        throw new ResourceNotFoundException();
                    }
                    ActivityLog updateEntity = converter.convert(activityLog, ActivityLog.class);
                    updateEntity.setId(entityId);
                    return converter.convert(repository.save(updateEntity), ActivityLogDto.class);
                }).orElseThrow(NullPointerException::new);
    }

    @Override
    public ActivityLogDto findById(Long id) {
        return Optional.ofNullable(id)
                .map(entityId -> {
                    ActivityLog entity = repository.findById(entityId).orElseThrow(ResourceNotFoundException::new);
                    return converter.convert(entity, ActivityLogDto.class);
                }).orElseThrow(NullPointerException::new);
    }

    @Override
    public void deleteById(Long id) {
        Optional.ofNullable(id)
                .ifPresent(entityId -> repository.deleteById(entityId));
    }

    @Override
    public List<ActivityLogDto> findAll() {
        return converter.convertList(repository.findAll(), ActivityLogDto.class);
    }
}
