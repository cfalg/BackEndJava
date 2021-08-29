package com.vehicles.persistence;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.project.AbsPersona;

public class PersonesRepository {

	private static List<AbsPersona> members = new ArrayList<>();

	public PersonesRepository() {
	}

	public List<AbsPersona> getAllMembers() {
		return new ArrayList<>(members);
	}

	public void addMember(AbsPersona member) throws Exception {
		if (member == null)
			throw new Exception();
		members.add(member);
	}
}
