package com.blacknebula.bonitaTheme.service;

import com.blacknebula.bonitaTheme.exception.FileStorageException;
import com.blacknebula.bonitaTheme.exception.MyFileNotFoundException;
import com.blacknebula.bonitaTheme.model.Theme;
import com.blacknebula.bonitaTheme.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public void updateContent(Long id, MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // Check if the file's name contains invalid characters
        if (fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        try {
            themeRepository.updateContent(id, file.getBytes());
        } catch (IOException ex) {
            throw new FileStorageException("Could not update theme content [" + fileName + "]. Please try again!", ex);
        }
    }

    public void updateCssContent(Long id, MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // Check if the file's name contains invalid characters
        if (fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        try {
            themeRepository.updateCssContent(id, file.getBytes());
        } catch (IOException ex) {
            throw new FileStorageException("Could not update theme css content [" + fileName + "]. Please try again!", ex);
        }
    }

    public Theme getTheme(Long id) {
        return themeRepository.findById(id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
    }
}