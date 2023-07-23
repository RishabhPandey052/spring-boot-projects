package org.pm.service;

import org.pm.entites.Certificate;
import org.pm.entites.Student;

public interface IStudentService {
	
	public Student addStudent(Student student);
	public Student updateStudent(Student student);
	
	public Student searchStudentById(long id);
	public Student searchStudentByHallTicket(long id);

	public boolean deleteStudent(Student student);
	
	public Certificate addCertificate(Certificate certificate);
	public Certificate updateCertificate(Certificate certificate);
	
}
