package org.trahim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Locale;

@Controller
public class FileController {

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/upoloadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file, Locale locale) {

        String name = null;

        if (!file.isEmpty()) {
            try {
                name = file.getOriginalFilename();
                File dir = new File("D:\\Загрузки" + File.separator + "tmpFile");

                if (!dir.exists()) {
                    dir.mkdir();
                }

                byte[] bytes = file.getBytes();
                File fileUpload = new File(dir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileUpload));
                stream.write(bytes);
                stream.flush();
                stream.close();

                return messageSource.getMessage("successfully", null, locale) + ": " + name;


            } catch (IOException e) {
                e.printStackTrace();
                return messageSource.getMessage("error", null, locale) + e.getMessage();
            }

        } else {
            return messageSource.getMessage("failed", new String[]{name}, locale);

        }

    }
}
