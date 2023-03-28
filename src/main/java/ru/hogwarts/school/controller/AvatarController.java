package ru.hogwarts.school.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.service.AvatarService;

import java.io.IOException;


@RestController
@RequestMapping("/avatar")
@AllArgsConstructor
public class AvatarController {
    private AvatarService service;

    @PostMapping(value = "/{studentId}/uploadAvatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadAvatar(@PathVariable Long studentId, @RequestParam MultipartFile avatarFile) throws IOException
    {
        service.uploadAvatar(studentId, avatarFile);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}/getAvatarFromDB")
    public ResponseEntity<byte[]> getAvatarFromDB(@PathVariable Long id)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(service.getMediaType(id)));
        headers.setContentLength(service.getAvatarFromDB(id).length);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.getAvatarFromDB(id));
    }
}
