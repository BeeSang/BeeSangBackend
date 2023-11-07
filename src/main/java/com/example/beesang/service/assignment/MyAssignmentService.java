package com.example.beesang.service.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyAssignmentService {

    @Transactional
    public void saveMyAssignment() {
        //assignment 전부 불러오고.
        //생성해서 save.. 진짜 ㅈㄴ 비효율적인거 아님
        //이부분은 좀 다시 생각해보자..
    }
}