package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Patient;
@Repository
public class PatientDaoImple implements PatientDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public void insertPatient(Patient patient) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(patient);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public void deletePatient(int patientId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Patient(patientId));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public void updatePatient(Patient patient) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.update(patient);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public Patient selectPatient(int patientId) {
	Patient pt = hibernateTemplate.execute(new HibernateCallback<Patient>() {

			@Override
			public Patient doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Patient p =(Patient)session.get(Patient.class, patientId);
				tr.commit();
				session.flush();
				session.close();
				return p;
			}
		});
		return pt;
	}

	@Override
	public List<Patient> selectAll(int doctorId) {
	List<Patient> plist = hibernateTemplate.execute(new HibernateCallback<List<Patient>>() {

			@Override
			public List<Patient> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q =session.createQuery("from Patient where doctorId = ?");
				q.setInteger(0, doctorId);
				List<Patient> p = q.list();
				tr.commit();
				session.flush();
				session.close();
				return p;
			}
		});
		return plist;
	}

	@Override
	public boolean checkPatient(Patient patient) {
	boolean b =	hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Patient where mobNo = ?");
				
				q.setString(0, patient.getMobNo());
				List<Patient> li = q.list();
				if(li.isEmpty()) {
					return false;
				}else {
					boolean flag = !li.isEmpty();
					patient.setPatientId(li.get(0).getPatientId());
					tr.commit();
					session.flush();
					session.close();
					return flag;
				}
				
			}
		});
		return b;
	}
	
}
