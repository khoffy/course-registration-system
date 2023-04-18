package edu.miu.courseregistrationsystem.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FacultyDto {
    private long id;
    private String name;
    private String email;
    private String title;
}
