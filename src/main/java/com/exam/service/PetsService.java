package com.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.exam.dto.PetsDTO;

public interface PetsService {

    // 모든 펫 조회
    List<PetsDTO> getAllPets();

    // 특정 유저의 펫 조회
    List<PetsDTO> getPetsByUserId(int userId);

    // 특정 펫 조회
    PetsDTO getPetById(int petId);

    // 펫 추가
    Map<String, String> addPet(PetsDTO pet, MultipartFile petImage);

    // 펫 정보 업데이트
    void updatePet(PetsDTO pet);

    // 펫 삭제
    void deletePet(int petId);
}
