package org.pm.service;

import org.pm.entites.Certificate;
import org.pm.entites.Student;
import org.pm.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IStudentServiceImpl  implements IStudentService{
	
	@Autowired
	IStudentRepository repoStudent;
	
	@Autowired
	ICertificateService serviceCertificate;
	
	@Override
	public Student addStudent(Student student) {
		Student s = repoStudent.save(student);		
		return s;
	}

	@Override
	public Student updateStudent(Student student) {
		Student s = repoStudent.save(student);		
		return s;
		
	}

	@Override
	public Student searchStudentById(long id) {
		Student s = repoStudent.findById(id).get();
		if(s != null) {
			return s;
		}
		return null;
	}

	@Override
	public Student searchStudentByHallTicket(long id) {
//		TODO
		return null;
	}

	@Override
	public boolean deleteStudent(Student student) {
		Student s = repoStudent.findById(student.getId()).get();
		if(s != null) {
			repoStudent.delete(s);
			return true;
		}
		return false;
	}

	@Override
	public Certificate addCertificate(Certificate certificate) {
		Certificate c = serviceCertificate.addCertificate(certificate);
		return c;
	}

	@Override
	public Certificate updateCertificate(Certificate certificate) {
		Certificate c = serviceCertificate.updateCertificate(certificate);
		return c;
	}

}
