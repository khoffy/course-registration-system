package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Feven
 * @version 1.0
 * @created 20-Dec-2022 12:00AM
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
