package com.example.beesang.dto.farm;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FarmUpdateResponse {
    private final int crops1;
    private final int crops2;
    private final int crops3;

    @Builder
    public FarmUpdateResponse(int crops1, int crops2, int crops3) {
        this.crops1 = crops1;
        this.crops2 = crops2;
        this.crops3 = crops3;
    }
}
