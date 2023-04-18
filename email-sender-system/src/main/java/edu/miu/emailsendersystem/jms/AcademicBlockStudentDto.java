package edu.miu.emailsendersystem.jms;


import java.time.LocalDate;

/**
 * @author Rediet
 * @version 1.0
 * @created 19/12/2020 10:51 PM
 */

public class AcademicBlockStudentDto {

    private long id;
    private String code;
    private String name;
    private String semester;
    private LocalDate startDate;
    private LocalDate endDate;

    public AcademicBlockStudentDto() {
    }

    public AcademicBlockStudentDto(long id, String code, String name, String semester, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
