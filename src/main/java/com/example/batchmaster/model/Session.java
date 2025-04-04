package com.example.batchmaster.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Document(collection = "sessions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id
    private String sessionId;

    @Indexed
    private String subject;

    @Indexed
    private String topic;

    @Indexed
    private String mentor;

    private String sessionLink;

    @Indexed
    private Date date; // Keeping Date as requested

    @Indexed
    private String batchId;

    @Indexed
    private String branchId;

    @Indexed
    private String day;

    @Indexed
    private String type;

    private Set<String> onlineStudentsIds;
    private Set<String> offlineStudentsIds;
    private Set<String> absentStudentsIds;

    private int week;

    @CreatedDate
    @Indexed
    private Instant createdAt;
}
