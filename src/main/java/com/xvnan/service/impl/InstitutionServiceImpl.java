package com.xvnan.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xvnan.mapper.InstitutionMapper;
import com.xvnan.model.Institution;
import com.xvnan.service.InstitutionService;
import org.springframework.stereotype.Service;

@Service
public class InstitutionServiceImpl extends ServiceImpl<InstitutionMapper, Institution> implements InstitutionService {
}
