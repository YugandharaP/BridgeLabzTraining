package com.bridgelabz.serviceimplementation;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.service.DoctorService;
import com.bridgelabz.utility.Utility;

/**This program is uesd to perforn some functions such as searchDoctorByName(),searchDoctorById(),searchDoctorByAvailability()
 * ,searchDoctorBySpecialization(),searchPopulardoctor(),searchPopularSpecialization().
 * @author yuga
 *
 */
public class DoctorServiceImplementation implements DoctorService {
	static ArrayList<Doctor> doctorList = new ArrayList<>();

	public DoctorServiceImplementation(String doctorFilePath) {
		doctorList = Utility.convertJsonToList(doctorFilePath, Doctor.class);
	}

	public DoctorServiceImplementation() {
	}

	/**To print doctors details
	 */
	@Override
	public void printDoctorDetails() {
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(CliniqueManager.DOCTOR_FILE_PATH));
			JSONArray doctorArray = (JSONArray) object;
			for (int i = 0; i < doctorArray.size(); i++) {
				JSONObject details = (JSONObject) doctorArray.get(i);
				System.out.println("index : " + i + " " + details);
			}
		} catch (IOException | ParseException e) {
			System.out.println("JSON file not fetched successfully");		}
	}

	/**To search doctor byName
	 */
	@Override
	public Doctor searchDoctorByName() {
		System.out.println("Enter doctor name:");
		String searchName=Utility.retNext();
		for(int i=0;i<doctorList.size();i++)
		{
			if(doctorList.get(i).getDoctorName().equalsIgnoreCase(searchName))
			{
				return doctorList.get(i);
			}
		}
		return null;

	}

	/**To search doctor byID
	 */
	@Override
	public Doctor searchDoctorById() {
		System.out.println("Enter doctor ID:");
		long doctorId=Utility.readLong();
		for(int i=0;i<doctorList.size();i++)
		{
			if(doctorList.get(i).getDoctorId()==doctorId)
			{
				return doctorList.get(i);
			}
		}
		return null;
	
	}
	/**To search doctor BySpecialization
	 */
	@Override
	public ArrayList<Doctor> searchDoctorBySpecialization(ArrayList<Doctor>list,String specialization) {
		for(int i=0;i<doctorList.size();i++)
		{
			if(doctorList.get(i).getSpecialization().equalsIgnoreCase(specialization))
			{
				list.add(doctorList.get(i));
			}
		}
		return list;
	}

	/**To search doctor ByAvailability()
	 */
	@Override
	public ArrayList<Doctor> searchDoctorByAvailability() {
		ArrayList<Doctor>list=new ArrayList<>();
		System.out.println("Enter doctor Availability:");
		String available=Utility.retNext();
		for(int i=0;i<doctorList.size();i++)
		{
			if(doctorList.get(i).getAvailable().equalsIgnoreCase(available))
			{
				list.add(doctorList.get(i));
			}
		}
		return list;
	}

	/**To search Populardoctor()
	 */
	@Override
	public void searchPopulardoctor() {
		ArrayList<Doctor>popularDoctor=	checkPopularity();
		for(int i =0;i<popularDoctor.size();i++)
		{
			System.out.println("Popular doctor is : "+popularDoctor.get(i).getDoctorName());
		}
	}

	/**To search PopularSpecialization()
	 */
	@Override
	public void searchPopularSpecialization() {
		ArrayList<Doctor>popularSpecialization=checkPopularity();
		for(int i=0;i<popularSpecialization.size();i++)
		{
			System.out.println("Popular Specialization : "+popularSpecialization.get(i).getSpecialization());
		}
	}
	/**
	 * @return popular doctor
	 */
	private ArrayList<Doctor> checkPopularity() {
		ArrayList<Long>patientCount=new ArrayList<>();
		ArrayList<Doctor>popularDoctor=new ArrayList<>();
		for(int i=0;i<doctorList.size();i++)
		{
			patientCount.add(doctorList.get(i).getPatientCount());
		}
		Collections.sort(patientCount);
		int rank=patientCount.size()-1;
		for(int i=0;i<doctorList.size();i++)
		{
			if(patientCount.get(rank)==doctorList.get(i).getPatientCount())
			{
				popularDoctor.add(doctorList.get(i));
			}
		}
		return popularDoctor;
	}
}
