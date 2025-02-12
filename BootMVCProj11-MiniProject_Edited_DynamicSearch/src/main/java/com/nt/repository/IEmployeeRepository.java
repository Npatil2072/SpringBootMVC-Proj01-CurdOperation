package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{
          
//	List<Employee> customSearch(Employee emp);
          
/*
 * @Query(value =
 * "SELECT * FROM emp WHERE sal > :sal AND ename = :ename AND job = :job " +
 * "AND (deptno = :deptNo1 OR deptno = :deptNo2 OR deptno = :deptNo3 OR deptno = '')"
 * , nativeQuery = true) List<Employee> findEmployeesByCriteria(@Param("salary")
 * double salary,
 * 
 * @Param("ename") String ename,
 * 
 * @Param("job") String job,
 * 
 * @Param("deptNo1") int deptNo1,
 * 
 * @Param("deptNo2") int deptNo2,
 * 
 * @Param("deptNo3") int deptNo3);
 */

	
	
	 @Query(value = "SELECT * FROM emp WHERE sal > :#{#emp.sal} OR ename = :#{#emp.ename} " +
             "OR job = :#{#emp.job} OR " +
             "(deptno = :#{#emp.deptno} " +
             " OR deptno = '')", 
     nativeQuery = true)
List<Employee> findEmployeesByCriteria(@Param("emp") Employee emp);

}

