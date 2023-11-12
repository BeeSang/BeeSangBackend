package com.example.beesang.dto.farm;

import com.example.beesang.domain.farm.Farm;
import com.example.beesang.domain.farm.FarmType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FarmReadResponse {
    private FarmType farmType;
    private Long farmId;
    private int crops1;
    private int crops2;
    private int crops3;

    public FarmReadResponse(Farm farm) {
        this.farmType = farm.getFarmType();
        this.farmId = farm.getId();
        this.crops1 = farm.getCrops1();
        this.crops2 = farm.getCrops2();
        this.crops3 = farm.getCrops3();
    }
}
