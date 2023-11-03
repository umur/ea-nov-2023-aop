package com.assginments.lab.service.Interfaces;

import com.assginments.lab.dto.ActivityLogDto;
import com.assginments.lab.dto.NewActivityLogDto;
import com.assginments.lab.entity.ActivityLog;
import com.assginments.lab.service.Generic.GenericService;

public interface ActivityLogService extends GenericService<ActivityLog, ActivityLogDto, NewActivityLogDto> {

}