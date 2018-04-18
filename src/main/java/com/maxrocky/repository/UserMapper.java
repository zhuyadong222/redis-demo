package com.maxrocky.repository;

import com.maxrocky.dto.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.*;

/**
 * @author yado
 * @create 2018-04-16 17:18
 * @desc
 **/
@Mapper
@CacheConfig(cacheNames = "users")
//@EnableCaching
public interface UserMapper {

    //根据id查询用户
    //将查询的数据存到redis缓存中，key = "#p0"指定第一参数作为redis的key
    //（未成功过）value属性上用#号隔开，第一个是原始的缓存容器名称，第二个是缓存的有效时间，第三个是缓存的自动刷新时间，单位都是秒。
    @Cacheable(value = "users#20#5", key = "#p0")
    @Select("select * from `user` where id = #{id}")
    User getUserById(Integer id);

    //保存用户
    @CachePut(value = "users", key = "#p0.id")
    @Insert("insert into `user` values (null, #{name}, #{age})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer saveUser(User user);

    //修改用户
    @CachePut(value = "users", key = "#p0.id")
    @Update("update `user` set name = #{name}, age = #{age} where id = #{id}")
    void updateUser(User user);

    //删除用户
    //allEntries = true如果指定为true，默认是false方法调用后立即删除所有缓存
    @CacheEvict(value = "users", key = "#p0", allEntries = false)
    @Delete("delete from `user` where id = #{id}")
    void deleteUserById(Integer id);

}