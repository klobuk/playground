package pl.pwpw.playground.attachmentsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.pwpw.playground.attachment.attachment;
import pl.pwpw.playground.attachmentServce.attachmentService;

import java.io.IOException;
import java.util.List;

@Controller
public class attachmentsController {

    @Autowired
    private attachmentService attachmentService;

    @RequestMapping("/")
    public String get(Model model)
    {
        List<attachment> attachments = attachmentService.getFiles();
        model.addAttribute("attachments",attachments);
        return "attachment";
    }

    @PostMapping("/uploadFiles")
    public String uploadMultipleFiles(@RequestParam("file") MultipartFile files,@RequestParam("AppNr") String AppNr)
    {
            try{
                attachmentService.store(files, AppNr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "redirect:/";
    }
}
