package com.admoney.admoneyusermanagementservice.Repos;

import com.admoney.admoneyusermanagementservice.Models.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepo extends CassandraRepository<User,String> {
    @AllowFiltering
    public User findUserByMobileNum(String mobileNum);
}
