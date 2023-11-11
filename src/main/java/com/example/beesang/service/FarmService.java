package com.example.beesang.service;

import com.example.beesang.domain.User;
import com.example.beesang.domain.farm.*;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.BeesangException;
import com.example.beesang.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FarmService {
    private final FarmRepository farmRepository;

    @Transactional
    public void createFarms(User user) {
        Farm tomatoFarm = new Farm(user, FarmType.TOMATO);
        farmRepository.save(tomatoFarm);

        Farm mangoFarm = new Farm(user, FarmType.MANGO);
        farmRepository.save(mangoFarm);

        Farm lettuceFarm = new Farm(user, FarmType.LETTUCE);
        farmRepository.save(lettuceFarm);

        Farm sweetPotatoFarm = new Farm(user, FarmType.SWEET_POTATO);
        farmRepository.save(sweetPotatoFarm);
    }

    public Farm findFarm(Long userId, FarmType farmType) {
        return farmRepository.findByUserIdAndFarmType(userId, farmType)
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.FARM_NOT_FOUND_EXCEPTION, 404));
    }
}