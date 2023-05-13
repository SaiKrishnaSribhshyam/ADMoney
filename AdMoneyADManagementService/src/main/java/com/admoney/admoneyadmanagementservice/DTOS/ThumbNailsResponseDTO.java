package com.admoney.admoneyadmanagementservice.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ThumbNailsResponseDTO {
    private List<CDNObjectDTO> rewardableAdThumbNails;
    private List<CDNObjectDTO> watchedAdThumbNails;
    private ResponseDTO responseDTO;
}
