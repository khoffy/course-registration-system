package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AcademicBlockStudentDto;
import edu.miu.courseregistrationsystem.dto.RegistrationGroupDto;
import edu.miu.courseregistrationsystem.dto.RegistrationGroupStudentDto;
import edu.miu.courseregistrationsystem.entity.*;
import edu.miu.courseregistrationsystem.mapper.RegistrationGroupMapper;
import edu.miu.courseregistrationsystem.repository.AcademicBlockRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationEventRepository;
import edu.miu.courseregistrationsystem.repository.RegistrationGroupRepository;
import edu.miu.courseregistrationsystem.repository.StudentRepository;
import edu.miu.courseregistrationsystem.service.RegistrationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 18-Dec-2022 5:59 PM
 */
@Service
@Transactional
public class RegistrationGroupServiceImp implements RegistrationGroupService {
    @Autowired
    private RegistrationGroupRepository registrationGroupRepository;
    @Autowired
    private RegistrationGroupMapper registrationGroupMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AcademicBlockRepository academicBlockRepository;
    @Autowired
    private RegistrationEventRepository registrationEventRepository;

    /**
     * @author Rediet
     * @param registrationGroupDto
     * @return RegistrationGroupDto
     * adming can create empty registration group
     */
    @Override
    public RegistrationGroupDto creatRegistrationGroup(RegistrationGroupDto registrationGroupDto) {
        System.out.println(registrationGroupMapper.registrationGroupFromRegistrationGroupDto(registrationGroupDto));
        registrationGroupRepository.save(registrationGroupMapper.registrationGroupFromRegistrationGroupDto(registrationGroupDto));
        return registrationGroupDto;
    }

    @Override
    public void updateRegistrationGroup(long registrationGroupId, List<Long> studentIds, Long academicBlockId) {
        /**
         * @param registrationGroupId
         * @param studentIds
         * @param academicBlockId
         * admin can update registration group by adding students and academic block
         * admin will add acadamic block to the existing academic block
         * admin will add a list of registered students to registration group
         */
        RegistrationGroup registrationGroup = registrationGroupRepository.findById(registrationGroupId).get();
        HashMap<Long, Student> existingStudent  = new HashMap<>();
        for (Student student: registrationGroup.getStudents()) {
            existingStudent.put(student.getId(), student);
        }

        for (Long studentId : studentIds) {
            Student student = studentRepository.findById(studentId).get();
            if (!existingStudent.containsKey(studentId)) {
                registrationGroup.getStudents().add(student);
            }
        }
        List<AcademicBlock> academicBlocksForRegistrationGroup = registrationGroup.getAcademicBlocks();
        AcademicBlock academicBlock = academicBlockRepository.findById(academicBlockId).get();
        academicBlocksForRegistrationGroup.add(academicBlock);
        registrationGroup.setAcademicBlocks(academicBlocksForRegistrationGroup);

        registrationGroupRepository.save(registrationGroup);
    }

    @Override
    public RegistrationGroup getRegistrationGroupById(long id) {
        return registrationGroupRepository.findById(id).get();
    }

    @Override
    public List<RegistrationGroupDto> getAllRegistrationGroups() {
        List<RegistrationGroup> registrationGroups = registrationGroupRepository.findAll();
        List<RegistrationGroupDto> registrationGroupDtos = registrationGroupMapper.registrationGroupDtosFromRegistrationGroups(registrationGroups);
        return registrationGroupDtos;
    }


    /**
     * @author Rediet
     * student can get all the registration group he/she is registered
     */
    @Override
    public List<RegistrationGroupStudentDto> getRegistrationGroupByStudentIds(long studentId) {
        List<RegistrationGroup> registrationGroups = registrationGroupRepository.findAll();
        List<RegistrationGroup> registrationGroups1 = new ArrayList<>();
        for (RegistrationGroup registrationGroup : registrationGroups) {
            List<Student> students = registrationGroup.getStudents();

            for (Student student: students) {
                System.out.println(student);
                if(student.getId() == studentId) {
                    System.out.println("TEST");
                    registrationGroups1.add(registrationGroup);
                }
            }
        }

        List<RegistrationGroupStudentDto> registrationGroupsForStudent = new ArrayList<>();
        for(RegistrationGroup registrationGroup : registrationGroups1){
            RegistrationGroupStudentDto registrationGroup1 = new RegistrationGroupStudentDto();
            registrationGroup1.setId(registrationGroup.getId());
            List<AcademicBlockStudentDto> academicBlockStudentDtos = new ArrayList<>();
            List<AcademicBlock> academicBlocks = registrationGroup.getAcademicBlocks();
            for (AcademicBlock academicBlock : academicBlocks) {
                AcademicBlockStudentDto academicBlockStudentDto = new AcademicBlockStudentDto();
                academicBlockStudentDto.setId(academicBlock.getId());
                academicBlockStudentDto.setCode(academicBlock.getCode());
                academicBlockStudentDto.setName(academicBlock.getName());
                academicBlockStudentDto.setSemester(academicBlock.getSemester());
                academicBlockStudentDto.setStartDate(academicBlock.getStartDate());
                academicBlockStudentDto.setEndDate(academicBlock.getEndDate());
                academicBlockStudentDtos.add(academicBlockStudentDto);
            }
            registrationGroup1.setAcademicBlocks(academicBlockStudentDtos);
            registrationGroupsForStudent.add(registrationGroup1);
        }
        return registrationGroupsForStudent;
    }

}
