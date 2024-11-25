package com.cdc.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cdc.entity.Doctor;
import com.cdc.service.IDoctorService;

@Component
public class SortTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorService service;

	/*@Override
	public void run(String... args) throws Exception {
		service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
		System.out.println("________________________________");
		service.showDoctorsBySorting(false, "docName").forEach(System.out::println);
	}*/

	@Override
	public void run(String... args) throws Exception {
		/*try {
			Page<Doctor> page = service.showDoctotsInfoByPageNumber(1, 2, true, "docName");
			System.out.println("PageNumber:: " + page.getNumber());
			System.out.println("PageNumber:: " + page.getSize());
			System.out.println("PageNumber:: " + page.getTotalPages());
			System.out.println("PageNumber:: " + page.isFirst());
			System.out.println("PageNumber:: " + page.isLast());
			if (!page.isEmpty()) {
				List<Doctor> list = page.getContent();
				list.forEach(System.out::println);
			} else {
				System.out.println("No Page found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		// Page By page
		service.showDoctorsPageByPage(2);
		// Deleteallbyidinbatch
		/*try {
			System.out.println(service.deleteDoctorsByIdsInBatch(List.of(1, 2)));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		try {
			Doctor doc = service.getDoctorByID(1);
			System.out.println(doc == null ? "Dooctor Not Found" : doc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
