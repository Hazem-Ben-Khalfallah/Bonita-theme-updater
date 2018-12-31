package com.blacknebula.bonitaTheme.controller;

import com.blacknebula.bonitaTheme.model.Theme;
import com.blacknebula.bonitaTheme.payload.UploadFileResponse;
import com.blacknebula.bonitaTheme.service.ThemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    private static final Logger logger = LoggerFactory.getLogger(ThemeController.class);

    @Autowired
    private ThemeService themeService;

    @GetMapping("/{id}/content")
    public ResponseEntity<Resource> downloadContent(@PathVariable Long id) {
        // Load file from database
        final Theme theme = themeService.getTheme(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/zip"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"content.zip\"")
                .body(new ByteArrayResource(theme.getContent()));
    }

    @PostMapping("/{id}/content/upload")
    public UploadFileResponse uploadContent(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        themeService.updateContent(id, file);

        String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/theme/")
                .path(id.toString())
                .path("/content")
                .toUriString();

        return new UploadFileResponse("content.zip", downloadUri,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/{id}/csscontent")
    public ResponseEntity<Resource> downloadCssContent(@PathVariable Long id) {
        // Load file from database
        final Theme theme = themeService.getTheme(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("text/css"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"csscontent.css\"")
                .body(new ByteArrayResource(theme.getCssContent()));
    }

    @PostMapping("/{id}/csscontent/upload")
    public UploadFileResponse uploadCssContent(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        themeService.updateCssContent(id, file);

        String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/theme/")
                .path(id.toString())
                .path("/csscontent")
                .toUriString();

        return new UploadFileResponse("csscontent.css", downloadUri,
                file.getContentType(), file.getSize());
    }
}