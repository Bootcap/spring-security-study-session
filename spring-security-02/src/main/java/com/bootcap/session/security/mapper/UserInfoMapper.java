package com.bootcap.session.security.mapper;

import com.bootcap.session.security.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 映射类
 * Created by jack.
 * 2018-12-10 16:26
 */
//@Mapper
@Repository
public interface UserInfoMapper {

    /**
     * 新增
     * @param userInfo
     * @return
     */
    @Insert("insert into user_info(user_name,user_password,user_roles) values(#{userName},#{password}, #{roles})")
    int insert(UserInfo userInfo);

    /**
     * 查询
     */
    @Select("select user_name as userName,user_password as password,user_roles as roles,user_id as id from user_info where user_name = #{userName}")
    UserInfo selectByUserName(@Param("userName") String userName);
}
