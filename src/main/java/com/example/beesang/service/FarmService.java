package com.example.beesang.service;

import com.example.beesang.domain.User;
import com.example.beesang.domain.farm.*;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.BeesangException;
import com.example.beesang.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FarmService {
    private final FarmRepository farmRepository;

    @Transactional
    public void createFarms(User user) {
        TomatoFarm tomatoFarm = new TomatoFarm(user);
        farmRepository.save(tomatoFarm);

        MangoFarm mangoFarm = new MangoFarm(user);
        farmRepository.save(mangoFarm);

        LettuceFarm lettuceFarm = new LettuceFarm(user);
        farmRepository.save(lettuceFarm);

        SweetPotatoFarm sweetPotatoFarm = new SweetPotatoFarm(user);
        farmRepository.save(sweetPotatoFarm);
    }

    public List<Farm> findAllByUserId(Long userId) {
        return farmRepository.findAllByUserId(userId)
                .orElseThrow(() -> new BeesangException(ExceptionErrorCode.FARM_NOT_FOUND_EXCEPTION, 404));
    }
}
