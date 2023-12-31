package com.movieapp.cinegraphqlapi.mapper;

import com.movieapp.cinegraphqlapi.dto.DirectorDto;
import com.movieapp.cinegraphqlapi.model.Director;

public class DirectorMapper {
    private DirectorMapper() {
    }

    public static DirectorDto entityToDto(Director director) {
        if (director == null)
            return null;
        DirectorDto dto = new DirectorDto();
        dto.setDirectorId(director.getDirectorId());
        dto.setName(director.getName());
        dto.setBirthDate(director.getBirthDate());
        dto.setBiography(director.getBiography());
        dto.setProfilePictureUrl(director.getProfilePictureUrl());
        return dto;
    }
}
