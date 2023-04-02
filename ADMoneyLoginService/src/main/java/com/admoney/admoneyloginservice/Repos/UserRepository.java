package com.admoney.admoneyloginservice.Repos;

import com.admoney.admoneyloginservice.Models.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepository extends CassandraRepository<User,String> {

    @AllowFiltering
    User findUserByMobileNum(String mobileNum);
}
