package com.example.springjpa.dao;

import com.example.springjpa.emtity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JpaRepository 泛型1 被操作的实体类 泛型2 主键属性的类型
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //自定义简单查询 主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称：
    List<UserEntity> findByName(String name);

    List<UserEntity> findByName(String name, Pageable pageable);

    //也使用一些加一些关键字And 、 Or
    UserEntity findByNameOrPassword(String name, String age);

    //修改、删除、统计也是类似语法
    void deleteById(Long id);
    Long countByName(String userName);

    //基本上 SQL 体系中的关键词都可以使用，例如： LIKE 、 IgnoreCase、 OrderBy。
    List<UserEntity> findByNameLike(String email);
    UserEntity findByNameIgnoreCase(String userName);
    List<UserEntity> findByNameOrderByNameDesc(String name);
}
