package admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_tbl")
public class User {
  /**
   * 所有的属性都应该在数据库中有
   */
  @TableField(exist = false)
  private String userName;
  @TableField(exist = false)
  private String password;


  // 以下是数据库字段
  private Long id;
  private String name;
  private Integer age;
  private String email;
}
