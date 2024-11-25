package com.cdc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cdc.entity.Doctor;
import com.cdc.repository.IDoctorRepository;

@Service("service")
public class DoctorServiceImpl implements IDoctorService {
	private static int i = 0;
	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
		Iterable<Doctor> it = doctorRepo.findAll(sort);
		return it;
	}

	@Override
	public Page<Doctor> showDoctotsInfoByPageNumber(int pageNo, int pageSize, boolean ascOrder, String props) {
		Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC);
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Doctor> page = (Page<Doctor>) doctorRepo.findAll((Sort) pageable);
		return page;
	}

	@Override
	public void showDoctorsPageByPage(int pageSize) {
		long count = doctorRepo.count();
		long pageCount = count / pageSize;
		pageCount = (count % pageSize == 0) ? pageCount : ++pageCount;

		for (i = 0; i < pageCount; ++i) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<Doctor> page = (Page<Doctor>) doctorRepo.findAll((Sort) pageable);
			page.forEach(System.out::println);

		}

	}

	@Override
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) {
		List<Doctor> list = doctorRepo.findAllById(ids);
		doctorRepo.deleteAllByIdInBatch(ids);
		return list.size() + "Records are deleted";
	}

	@Override
	public Doctor getDoctorByID(int id) {
		Doctor doctor = doctorRepo.getReferenceById(id);
		return doctor;
	}

}
