package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Table
public class WatchedAd extends BaseModel{
    @OneToMany
    private Ad ad;
    @OneToMany
    private User user;
}
