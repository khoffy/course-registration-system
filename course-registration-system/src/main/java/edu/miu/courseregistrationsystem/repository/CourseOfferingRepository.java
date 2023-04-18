package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Long> {

    //List<CourseOffering> findByStudentsId(long studentId);
}
