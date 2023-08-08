package ru.hogwarts.school.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvatarDTO {
    private Long id;
    private String filePath;
    private long fileSize;
    private String mediaType;

    private Long studentId;
}
