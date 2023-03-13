package admin.service.impl;

import admin.bean.SysConfig;
import admin.mapper.SysConfigMapper;
import admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  private SysConfigMapper sysConfigMapper;

  @Override
  public SysConfig getSysById(String id) {
    return sysConfigMapper.getAcct(id);
  }
}
