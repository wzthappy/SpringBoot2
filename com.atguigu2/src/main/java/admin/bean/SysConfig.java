package admin.bean;

import lombok.Data;

import java.util.Date;

@Data
public class SysConfig {
  private String variable;
  private String value;
  private Date setTime;
  private String setBy;

}
