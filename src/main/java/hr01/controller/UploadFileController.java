package hr01.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class UploadFileController {
    @PostMapping("/uploadFile")
    public List<String> uploadFileProcess(@RequestParam("uploadFiles") MultipartFile[] uploadFiles, HttpServletRequest request) {
        List<String> urls=new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(new Date());
        String urlString;
        //MultipartFile uploadFile=uploadFiles[0];

        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/") + dateString + "\\";
        File folder = new File(realPath);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        System.out.println(realPath);

        for (MultipartFile uploadFile : uploadFiles) {
            String oldName = uploadFile.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
            try {
                uploadFile.transferTo(new File(folder, newName));
                urlString = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                        + "/uploadFile/" + dateString + "/" + newName;
                urls.add(urlString);
                System.out.println(urlString);
                throw new MaxUploadSizeExceededException(-1);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("上传失败！");
            }
        }

        return urls;
    }
}
