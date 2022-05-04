package dev.tommasobenatti.experienceshare.rest;

import dev.tommasobenatti.experienceshare.Lang;
import dev.tommasobenatti.experienceshare.image.ImageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

@Controller
public class UploadImageController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<?> upload(HttpServletRequest request) {
        String key = request.getHeader("key");
        if (!key.equals(Lang.API_KEY.getValue())) {
            return new ResponseEntity<>("Invalid Key", HttpStatus.BAD_REQUEST);
        }
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartRequest.getFileNames();
            MultipartFile multipart = multipartRequest.getFile(it.next());
            if (multipart == null) {
                return new ResponseEntity<>("MultipartFile is null", HttpStatus.BAD_REQUEST);
            }


            String fileExtension = multipart.getOriginalFilename().substring(multipart.getOriginalFilename().lastIndexOf("."));
            String fileName = multipart.getOriginalFilename().substring(0, multipart.getOriginalFilename().lastIndexOf("."));
            fileName = fileName + ImageHelper.getRandomId() + fileExtension;
            byte[] bytes = multipart.getBytes();

            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(ImageHelper.createImgFile(fileName)))) {
                stream.write(bytes);
            } catch (Exception e) {
                return new ResponseEntity<>("Error to upload file", HttpStatus.BAD_REQUEST);
            }

            String url = Lang.DOMAIN.getValue() + "/" + fileName;
            return new ResponseEntity<>(url, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error to upload file", HttpStatus.BAD_REQUEST);
        }
    }
}
