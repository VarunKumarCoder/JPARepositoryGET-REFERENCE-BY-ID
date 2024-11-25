package com.cdc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cdc.entity.Doctor;

public interface IDoctorService {

	public Page<Doctor> showDoctotsInfoByPageNumber(int pageNo, int pageSize, boolean ascOrder, String props);

	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props);

	public void showDoctorsPageByPage(int pageSize);

	public String deleteDoctorsByIdsInBatch(List<Integer> ids);

}
