package com.example.springjpa.emtity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data  //lombok 注解  生成get set 等
@Entity //告诉JPA这是一个实体类（一个和数据表映射的类）
@Table(name = "user") //配置当前实体类和哪张表对应；可以省略不写，如果省略默认表名和实体的名称保持一致。
@EntityListeners(value = AuditingEntityListener.class) //开启自动审计
public class UserEntity {
    @Id //代表这是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成规则 IDENTITY 自增
    private Long id;
    @Column(length = 32) //声明了字符字段的长度。如果不这么声明，则系统会采用 255 作为该字段的长度
    private String name;
    private String password;

    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;
}
