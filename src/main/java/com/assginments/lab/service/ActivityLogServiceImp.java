package com.assginments.lab.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assginments.lab.dto.ActivityLogDto;
import com.assginments.lab.dto.NewActivityLogDto;
import com.assginments.lab.entity.ActivityLog;
import com.assginments.lab.repository.ActivityLogRepo;
import com.assginments.lab.service.Generic.GenericServiceImp;
import com.assginments.lab.service.Interfaces.ActivityLogService;

@Service
public class ActivityLogServiceImp
        extends GenericServiceImp<ActivityLog, ActivityLogDto, NewActivityLogDto, ActivityLogRepo>
        implements ActivityLogService {
    private ActivityLogRepo activityLogRepo;
    private ModelMapper mapper;

    @Autowired
    public ActivityLogServiceImp(ActivityLogRepo repo, ModelMapper mapper) {
        super(repo, mapper);
        this.activityLogRepo = repo;
        this.mapper = mapper;
    }

    @Override
    public Class<ActivityLogDto> getTDtoClass() {
        return ActivityLogDto.class;
    }

    @Override
    public Class<ActivityLog> getTEntityClass() {
        return ActivityLog.class;
    }

    @Override
    public Class<NewActivityLogDto> getTNewEntityDtoClass() {
        return NewActivityLogDto.class;
    }

}