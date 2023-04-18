package edu.miu.courseregistrationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Redie
 * @version 1.0
 * @created 19/12/2020 5:57 PM
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseOfferingStudentDto {
    private long id;
    private String code;
    private long capacity;
    private long availableSeats;
    private String initials;
}
