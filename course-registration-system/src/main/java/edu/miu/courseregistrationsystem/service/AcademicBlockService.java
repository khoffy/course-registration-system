package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.AcademicBlockDto;
import edu.miu.courseregistrationsystem.dto.AcademicBlockStudentDto;

import java.util.List;

public interface AcademicBlockService {
    public AcademicBlockDto createAcademicBlock(AcademicBlockDto academicBlockDto);
    public AcademicBlockDto getAcademicBlock(long id);
    public AcademicBlockDto updateAcademicBlock(long id, AcademicBlockDto academicBlockDto);
    public void deleteAcademicBlock(long id);
    public List<AcademicBlockDto> getAllAcademicBlocks();
    /**
     * @author Rediet
     * student can get all the academic blocks he/she is registered
     */
    public List<AcademicBlockStudentDto> getAcademicBlocksByStudent(long studentId);
}
