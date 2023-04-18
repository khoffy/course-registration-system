package edu.miu.emailsendersystem.jms;



import java.util.List;
/**
 * @author Redie
 * @version 1.0
 * @created 19/12/2020 5:57 PM
 */

public class RegistrationGroupStudentDto {
    long id;
    private List<AcademicBlockStudentDto> academicBlocks;

    public RegistrationGroupStudentDto() {
    }

    public RegistrationGroupStudentDto(long id, List<AcademicBlockStudentDto> academicBlocks) {
        this.id = id;
        this.academicBlocks = academicBlocks;
    }

    public long getId() {
        return id;
    }

    public List<AcademicBlockStudentDto> getAcademicBlocks() {
        return academicBlocks;
    }
}
