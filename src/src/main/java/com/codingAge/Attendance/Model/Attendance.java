package com.codingAge.Attendance.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Attendance {
    @Id
    private String attendanceId;
    private String batchId;
    private String date;
    private String studentId;
    private String status;
}
