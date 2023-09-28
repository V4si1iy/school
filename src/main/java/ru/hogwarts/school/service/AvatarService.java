package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;


@Service
public class AvatarService {
    private static Logger logger = LoggerFactory.getLogger(AvatarService.class);
    @Value("${path.to.avatars.folder}")
    private String avatarsDir;


    AvatarRepository avatarRepository;
    StudentRepository studentRepository;

    public AvatarService(AvatarRepository avatarRepository, StudentRepository studentRepository) {
        this.avatarRepository = avatarRepository;
        this.studentRepository = studentRepository;
    }

    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        logger.info("Was invoked method for upload avatar");
        Student student = studentRepository.findById(studentId).get();
        Path filePath = Path.of(avatarsDir, "ID =" + student.getId());
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (
                InputStream is = avatarFile.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, StandardOpenOption.CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 2048);
                BufferedOutputStream bos = new BufferedOutputStream(os, 2048);
        ) {
            bis.transferTo(bos);
        }
        Avatar avatar = new Avatar();
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setData(avatarFile.getBytes());
        avatar.setMediaType(avatarFile.getContentType());
        student.setAvatar(avatar);
        avatarRepository.save(avatar);
        studentRepository.save(student);

    }

    public byte[] getAvatarFromDB(Long id) {
        logger.info("Was invoked method to get avatar from Data Base by id");
        Avatar avatar = getAvatar(id);
        return avatar.getData();
    }

    public String getMediaType(Long id) {
        logger.info("Was invoked method to get Media type of file by id");
        Avatar avatar = getAvatar(id);
        return avatar.getMediaType();
    }

    public Avatar getAvatar(Long id) {
        logger.info("Was invoked method to get avatar by id");
        return avatarRepository.getReferenceById(id);
    }

    public List<Avatar> getAll(Integer pageNumber, Integer pageSize) {
        logger.info("Was invoked method to get all avatars by pages");
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return avatarRepository.findAll(pageRequest).getContent();
    }
}
