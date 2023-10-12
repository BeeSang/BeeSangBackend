package com.example.beesang.dto.shcool;

import com.example.beesang.domain.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolReadAllResponse {
    List<School> schools = new ArrayList<>();
}
