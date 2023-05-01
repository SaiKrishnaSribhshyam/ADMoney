package com.admoney.admoneyusermanagementservice.Repos;

import com.admoney.admoneyusermanagementservice.Models.UserProfile;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepo extends CassandraRepository<UserProfile,String> {
    @AllowFiltering
    UserProfile findUserProfileByMobileNum(String mobileNum);
}
