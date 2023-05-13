package com.admoney.admoneyadmanagementservice.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Table
public class AdImpressions extends BaseModel{
    @OneToOne
    private Ad ad;
    private int totalImpressions;
    private int activeWatchers;

}
