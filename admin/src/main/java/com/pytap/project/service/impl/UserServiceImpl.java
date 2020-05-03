package com.pytap.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.project.dao.UserMapper;
import com.pytap.project.dao.UserRoleMapper;
import com.pytap.project.entity.User;
import com.pytap.project.entity.UserExample;
import com.pytap.project.entity.UserRole;
import com.pytap.project.service.UserService;
import com.pytap.project.utils.ImageUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Ecin520
 * @date 2020/3/26 22:04
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    @Cacheable
    public Integer countUser() {
        return userMapper.countByExample(null);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @CacheEvict(allEntries = true)
    public Integer insertUser(User user) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());

        if (1 != userMapper.selectByExample(userExample).size()) {
            return null;
        }

        user.setCreateTime(new Date());
        user.setStatus(1);
        user.setAvatar(ImageUtil.IMAGE_COLLECTION[new Random().nextInt(ImageUtil.IMAGE_COLLECTION.length)]);


        String encryption = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryption);

        int result = userMapper.insert(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(1001L);

        userRoleMapper.insert(userRole);
        return result;
    }

    @Override
    @CacheEvict(allEntries = true)
    public Integer deleteByUserId(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @CacheEvict(allEntries = true)
    public Integer updateByUserId(User user) {
        User userInfo = userMapper.selectByPrimaryKey(user.getId());
        if (!userInfo.getPassword().equals(user.getPassword())) {
            String encryption = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryption);
        }
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Cacheable(key = "'by-id' + #id")
    public User getByUserId(Long id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        return userMapper.selectByExample(userExample).get(0);
    }

    @Override
    @Cacheable(key = "'by-username' + #username")
    public User getByUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.selectByExample(userExample).get(0);
    }

    @Override
    @Cacheable(key = "'all-user' + #pageNum + '-' + #pageSize")
    public List<User> listAllUsers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample userExample = new UserExample();
        return userMapper.selectByExample(userExample);
    }
}
