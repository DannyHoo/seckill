package com.danny.seckill.dao.jpa.dao.system;

import com.danny.seckill.dao.jpa.dao.base.BaseDao;
import com.danny.seckill.dao.jpa.data.system.UserDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author dannyhoo
 * @Title: UserDAO
 * @Description:
 * @Created on 2017-02-18 14:54:43
 */
public interface UserDAO extends BaseDao<UserDO>,PagingAndSortingRepository<UserDO,Long>{

    @Modifying
    @Query("update UserDO u set u.userName=?2 where u.id=?1")
    int updateUserName(Long userId, String userName);


    UserDO findByUserNameAndPassword(String userName, String password);


    UserDO findByUserName(String userName);
}
