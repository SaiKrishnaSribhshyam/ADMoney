package com.admoney.admoneyadmanagementservice.DTOS;

import com.admoney.admoneyadmanagementservice.Models.Key;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KeysResponseDTO {
    private List<Key> keysList;
    private ResponseDTO responseDTO;
}
