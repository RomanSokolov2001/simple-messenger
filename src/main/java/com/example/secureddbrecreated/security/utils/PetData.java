package com.example.secureddbrecreated.security.utils;

import com.example.secureddbrecreated.security.dto.PetResponseDto;
import com.example.secureddbrecreated.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PetData {


    private PetData(){}

    public static List<PetResponseDto> getPets() {

        return List.of(PetResponseDto.builder().name("Orejas").build(),
                PetResponseDto.builder().name("Puppy").build());
    }
}
