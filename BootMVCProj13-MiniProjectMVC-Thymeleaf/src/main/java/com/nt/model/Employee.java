package com.nt.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
	@Id
	//@SequenceGenerator(name="gen1",sequenceName="emp_id_seq",initialValue = 1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empno;
	@Column(length=30)
	private String ename;
	
	private Float sal;
	@Column(length=30)
	private String job;
    private Integer deptno;
}
