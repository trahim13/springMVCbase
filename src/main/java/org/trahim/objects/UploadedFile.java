package org.trahim.objects;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {
    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
