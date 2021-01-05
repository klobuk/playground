package pl.pwpw.playground.attachmentServce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.pwpw.playground.repository.attachmentRepository;
import pl.pwpw.playground.attachment.attachment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class attachmentService {

    @Autowired
    private attachmentRepository attachmentRepository;

    public attachment store(MultipartFile file, String AppNr) throws IOException{
        Date nowDate = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("dd.MM.yyyy");
        attachment attachment = new attachment(file.getBytes(),(String)simple.format(nowDate), file.getContentType(),AppNr);
        return attachmentRepository.save(attachment);
    }

    public List<attachment> getFiles()
    {
        return attachmentRepository.findAll();
    }
}
