package com.alipay.test.download.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.alipay.test.download.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
