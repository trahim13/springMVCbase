package org.trahim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.trahim.objects.UploadedFile;
import org.trahim.validators.FileValidator;

import java.io.*;
import java.util.Locale;

@SessionAttributes("fileName")
@Controller
public class FileController {

    @Autowired
   private MessageSource messageSource;

    @Autowired
    private FileValidator fileValidator;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView uploadFile(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult bindingResult, Locale locale) {

        ModelAndView modelAndView = new ModelAndView();

        String name;
        MultipartFile file = uploadedFile.getFile();

        fileValidator.validate(uploadedFile, bindingResult);

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("main");
        } else {
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

                RedirectView redirectView = new RedirectView("fileuploaded");
                redirectView.setStatusCode(HttpStatus.FOUND);
                modelAndView.setView(redirectView);
                modelAndView.addObject("fileName", name);
            } catch (IOException e) {
                e.printStackTrace();
                String message = messageSource.getMessage("error", null, locale) + e.getMessage();
                modelAndView.addObject("message", message);
                return modelAndView;

            }

        }

        return modelAndView;
    }

    @RequestMapping(value = "/fileuploaded", method = RequestMethod.GET)
    public String fileUploaded() {
        return "fileuploaded";
    }

}
