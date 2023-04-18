package edu.miu.courseregistrationsystem.service;

import edu.miu.courseregistrationsystem.dto.RegistrationGroupDto;
import edu.miu.courseregistrationsystem.dto.RegistrationGroupStudentDto;
import edu.miu.courseregistrationsystem.entity.RegistrationGroup;

import java.util.List;

public interface RegistrationGroupService {
    public RegistrationGroupDto creatRegistrationGroup (RegistrationGroupDto registrationGroupDto);
    public void updateRegistrationGroup (long registrationGroupId, List<Long> studentIds,Long academicBlockId);
    public RegistrationGroup getRegistrationGroupById(long id);
    public List<RegistrationGroupDto> getAllRegistrationGroups();

    /**
     * @author Rediet
     * student can get all the registration group he/she is registered
     */
    public List<RegistrationGroupStudentDto> getRegistrationGroupByStudentIds(long studentId);
 }
