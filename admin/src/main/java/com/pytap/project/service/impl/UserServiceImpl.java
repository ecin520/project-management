package com.pytap.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.project.dao.UserDao;
import com.pytap.project.entity.User;
import com.pytap.project.entity.UserRole;
import com.pytap.project.service.UserRoleService;
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
    private UserRoleService userRoleService;

    @Resource
    private UserDao userDao;

    @Override
    @Cacheable
    public Integer countUser() {
        return userDao.countUser();
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @CacheEvict(allEntries = true)
    public Integer insertUser(User user) {
        user.setCreateTime(new Date());
        user.setStatus(1);
        user.setAvatar(ImageUtil.IMAGE_COLLECTION[new Random().nextInt(ImageUtil.IMAGE_COLLECTION.length)]);
        if (null != userDao.getByUsername(user.getUsername())) {
            return null;
        }
        String encryption = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryption);
        int result = userDao.insertUser(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(1001L);
        userRoleService.insertUserRole(userRole);
        return result;
    }

    @Override
    @CacheEvict(allEntries = true)
    public Integer deleteByUserId(Long id) {
        return userDao.deleteByUserId(id);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @CacheEvict(allEntries = true)
    public Integer updateByUserId(User user) {
        User example = userDao.getByUserId(user.getId());
        if (!example.getPassword().equals(user.getPassword())) {
            String encryption = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryption);
        }
        return userDao.updateByUserId(user);
    }

    @Override
    @Cacheable(key = "'by-id' + #id")
    public User getByUserId(Long id) {
        return userDao.getByUserId(id);
    }

    @Override
    @Cacheable(key = "'by-username' + #username")
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    @Cacheable(key = "'all-user' + #pageNum + '-' + #pageSize")
    public List<User> listAllUsers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userDao.listAllUsers();
    }
}
