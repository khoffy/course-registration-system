package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.StudentDto;
import edu.miu.courseregistrationsystem.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * * @author: Redie
 * @author <a href="mailto:hermann.tipoh@gmail.com">Koffi Adolf Hermann Tipoh </a>
 * @version %I% %G%
 * @since 12/17/2022
 *
 * Interface to map StudentDto to Student and vice versa
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {

    public Student studentFromStudentDto(StudentDto studentDto);

    public StudentDto studentDtoFromStudent(Student student);

    public List<StudentDto> studentDtosFromStudents(List<Student> students);

    public List<Student> studentsFromStudentDtos(List<StudentDto> studentDtos);
}


