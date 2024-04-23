user_info.csv 文件存储了电商互联网平台上收集的用户数据，数据中有以下内容: 
  id：主键非空，bigint类型，长度为 20 
  login_name：用户名，varchar类型，长度200 
  nick_name：用户昵称，varchar类型，长度200 
  passwd：密码，varchar 类型，长度200 
  name：姓名，varchar 类型，长度200 
  phone_num:手机号，varchar 类型，长度200 
  email:邮箱，varchar 类型，长度200 
  head_img:头像，varchar 类型，长度200 
  user_level:用户级别，varchar类型，长度200 
  birthday:用户生日，date 类型，长度 0，格式为YYYY-MM-DD 
  gender:性别，varchar 类型，长度1 
  create_time: 创建时间，datetime 类型，格式为 yyyy-MM-dd HH:mm:ss  
  operate_time:修改时间，datetime 类型，格式为 yyyy-MM-dd HH:mm:ss
利用Scala编写Spark程序，实现以下功能：对于 gender 这一字段统计电商消费人数男女数量，将结果写入 HDFS 中，格式为: (性别,人数)，如:(男,10)，在控制台读取 HDFS 文件输出男女各多少人。
