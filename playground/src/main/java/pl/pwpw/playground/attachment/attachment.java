package pl.pwpw.playground.attachment;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FILE")
public class attachment {

    @Id
    @SequenceGenerator(name = "app_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_id_seq")
    private long attachmentId;

    private byte [] attachmentBody;

    private String attachmentDate;

    private String attachmentType;

    private String AppNr;

    public attachment(){}

    public attachment( byte[] attachmentBody, String attachmentDate, String attachmentType, String AppNr) {
        this.attachmentBody = attachmentBody;
        this.attachmentDate = attachmentDate;
        this.attachmentType = attachmentType;
        this.AppNr = AppNr;
    }

    public String getAppNr() {
        return AppNr;
    }

    public void setAppNr(String appNr) {
        AppNr = appNr;
    }
    public long getAttachentId() {
        return attachmentId;
    }

    public void setAttachentId(long attachmentId) { this.attachmentId = attachmentId; }

    public byte[] getAttachmentBody() {
        return attachmentBody;
    }

    public void setAttachmentBody(byte[] attachmentBody) {
        this.attachmentBody = attachmentBody;
    }

    public String getAttachmnetDate() {
        return attachmentDate;
    }

    public void setAttachmnetDate(String attachmnetDate) {
        this.attachmentDate = attachmnetDate;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }
}
