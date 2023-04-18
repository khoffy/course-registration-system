package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
