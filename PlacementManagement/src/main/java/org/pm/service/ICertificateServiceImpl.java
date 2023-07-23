package org.pm.service;

import org.pm.entites.Certificate;
import org.pm.repository.ICertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICertificateServiceImpl implements ICertificateService{
	
	@Autowired
	ICertificateRepository repoCertificate;

	@Override
	public Certificate addCertificate(Certificate certificate) {
		Certificate c = repoCertificate.save(certificate);
		return c;
	}

	@Override
	public Certificate updateCertificate(Certificate certificate) {
		Certificate c = repoCertificate.save(certificate);
		return c;
	}

	@Override
	public Certificate searchCertificate(long id) {
		Certificate c = repoCertificate.findById(id).get();
		if(c != null) {
			return c;
		}
		return null;
		
	}

	@Override
	public Certificate deleteCertificate(long id) {
		Certificate s = repoCertificate.findById(id).get();
		if(s != null) {
			repoCertificate.delete(s);
			return s;
		}
		return null;

	}
	
	

}
