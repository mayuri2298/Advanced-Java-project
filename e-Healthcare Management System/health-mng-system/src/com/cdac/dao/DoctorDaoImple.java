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

import com.cdac.dto.Doctor;
@Repository
public class DoctorDaoImple implements DoctorDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public void insertDoctor(Doctor doctor) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(doctor);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Doctor(doctorId));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.update(doctor);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public Doctor selectDoctor(int doctorId) {
	Doctor dr =	hibernateTemplate.execute(new HibernateCallback<Doctor>() {

			@Override
			public Doctor doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Doctor d =(Doctor)session.get(Doctor.class, doctorId);
				tr.commit();
				session.flush();
				session.close();
				return d;
			}
		});
		return dr;
	}

	@Override
	public List<Doctor> selectAll() {
	List<Doctor> l = hibernateTemplate.execute(new HibernateCallback<List<Doctor>>() {

			@Override
			public List<Doctor> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Doctor");
				List<Doctor> li =q.list(); 
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
		return l;
	}

	@Override
	public boolean checkDoctor(Doctor doctor) {
	boolean n =	hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Doctor where doctorName = ? and doctorPass = ?");
				q.setString(0, doctor.getDoctorName());
				q.setString(1, doctor.getDoctorPass());
				List<Doctor> li = q.list();
				if(li.isEmpty()) {
					return false;
				}else {
					boolean flag = !li.isEmpty();
					doctor.setDoctorId(li.get(0).getDoctorId());
					tr.commit();
					session.flush();
					session.close();
					return flag;
				}
				
				
			}
		});
		return n;
	}
	
}
