package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.AcademicBlockDto;
import edu.miu.courseregistrationsystem.dto.AcademicBlockStudentDto;
import edu.miu.courseregistrationsystem.entity.AcademicBlock;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * @author Rediet
 * @version 1.0
 * @created 10/12/2020 12:04 AM
 */
@Mapper(componentModel = "spring")
public interface AcademicBlockMapper {
    public AcademicBlock academicBlockFromAcademicBlockDto(AcademicBlockDto academicBlockDto);
    public AcademicBlockDto academicBlockDtoFromAcademicBlock(AcademicBlock academicBlock);
    public List<AcademicBlockDto> academicBlockDtosFromAcademicBlocks(List<AcademicBlock> academicBlocks);
    public List<AcademicBlock> academicBlocksFromAcademicBlockDtos(List<AcademicBlockDto> academicBlockDtos);


}
