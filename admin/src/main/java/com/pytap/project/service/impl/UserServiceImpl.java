package com.pytap.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.project.dao.UserDao;
import com.pytap.project.entity.User;
import com.pytap.project.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/26 22:04
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserDao userDao;

    @Override
    public Integer countUser() {
        return userDao.countUser();
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Integer insertUser(User user) {
        user.setCreateTime(new Date());
        user.setStatus(1);
        if (null != userDao.getByUsername(user.getUsername())) {
            return null;
        }
        String encryption = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryption);
        return userDao.insertUser(user);
    }

    @Override
    public Integer deleteByUserId(Long id) {
        return userDao.deleteByUserId(id);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Integer updateByUserId(User user) {
        User example = userDao.getByUserId(user.getId());
        if (!example.getPassword().equals(user.getPassword())) {
            String encryption = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryption);
        }

        return userDao.updateByUserId(user);
    }

    @Override
    public User getByUserId(Long id) {
        return userDao.getByUserId(id);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public List<User> listAllUsers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userDao.listAllUsers();
    }
}
