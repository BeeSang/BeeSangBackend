package com.example.beesang.service;

import com.example.beesang.domain.User;
import com.example.beesang.domain.farm.*;
import com.example.beesang.dto.farm.FarmHarvestRequest;
import com.example.beesang.dto.farm.FarmUpdateRequest;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.BeesangException;
import com.example.beesang.repository.FarmRepository;
import com.example.beesang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FarmService {
    private final FarmRepository farmRepository;
    private final UserRepository userRepository;
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

    @Transactional
    public void growCrops(Long farmId, Long userId, FarmUpdateRequest request) {
        Farm findFarm = farmRepository.findById(farmId)
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.FARM_NOT_FOUND_EXCEPTION, 404));

        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.USER_NOT_FOUND_EXCEPTION, 404));

        if(findUser.getBees() < 5) {
            throw new BeesangException(ExceptionErrorCode.NOT_ENOUGH_BEES_EXCEPTION, 403);
        }

        findFarm.update(request.getCrops1(), request.getCrops2(), request.getCrops3());
        findUser.updateBees(-5);
    }

    @Transactional
    public void harvestCrops(Long farmId, Long userId, FarmHarvestRequest request) {
        Farm findFarm = farmRepository.findById(farmId)
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.FARM_NOT_FOUND_EXCEPTION, 404));

        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.USER_NOT_FOUND_EXCEPTION, 404));

        //수확할 작물이 없으면 수확 불가 -> 예외처리
        if(request.getCrops1() < 0 || request.getCrops2() < 0 || request.getCrops3() < 0) {
            throw new BeesangException(ExceptionErrorCode.NOT_ENOUGH_CROPS_EXCEPTION, 403);
        }

        findUser.updateCoin(100 * request.getHarvestCount());
        findFarm.update(request.getCrops1(), request.getCrops2(), request.getCrops3());
    }
}