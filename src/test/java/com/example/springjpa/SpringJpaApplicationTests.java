package com.example.springjpa;

import com.example.springjpa.dao.UserRepository;
import com.example.springjpa.emtity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {

    }

    /**
     * 新增操作
     */
    @Test
    void testSave() {
        UserEntity user = new UserEntity();
        user.setName("王五");
        user.setPassword("123456");
        userRepository.save(user);
    }

    /**
     * 更新操作
     */
    @Test
    void testUpdate() {
        Optional<UserEntity> optional=userRepository.findById(1L);
        if (optional.isPresent()){
            UserEntity user =  optional.get();
            user.setName("李四");
            userRepository.save(user);
        }
    }

    /**
     * 删除操作
     */
    @Test
    void testDelete() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        userRepository.delete(user);
    }

    /**
     * 获取所有用户列表
     */
    @Test
    void testFindAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        System.out.println(userEntities);
    }

    /**
     * 自定义按属性名查询
     */
    @Test
    void testFindByName() {
        List<UserEntity> userEntities = userRepository.findByName("张三");
        System.out.println(userEntities);
    }

    /**
     * 分页查询
     * @throws Exception
     */
    @Test
    public void testPageQuery() throws Exception {
        //设置分页参数
        Pageable pageable = PageRequest.of(0,1);
        System.out.println(userRepository.findAll(pageable).getContent());
    }

    /**
     * 分页查询
     * @throws Exception
     */
    @Test
    public void testSort() throws Exception {
        Sort sort = new Sort(Sort.Direction.DESC, Arrays.asList("id"));
        System.out.println(userRepository.findAll(sort));
    }
}
