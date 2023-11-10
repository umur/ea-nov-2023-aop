package edu.miu.ea.aop.service.logging.impl;

import edu.miu.ea.aop.model.domain.logging.JPActivityLog;
import edu.miu.ea.aop.repository.logging.JPActivityLogRepository;
import edu.miu.ea.aop.service.logging.JPActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JPActivityLogServiceImpl implements JPActivityLogService {

    private final JPActivityLogRepository repository;

    @Override
    @Transactional
    public JPActivityLog add(JPActivityLog activityLog) {
        return repository.save(activityLog);
    }

}
