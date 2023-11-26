package com.example.beesang.dto.farm;

import lombok.Data;

@Data
public class FarmHarvestRequest {
    private int crops1;
    private int crops2;
    private int crops3;
    private int harvestCount;
}
