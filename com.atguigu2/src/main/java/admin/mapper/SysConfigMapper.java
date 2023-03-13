package admin.mapper;

import admin.bean.SysConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysConfigMapper {

  SysConfig getAcct(String variable);
}
