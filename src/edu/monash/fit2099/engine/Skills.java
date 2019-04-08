package edu.monash.fit2099.engine;

import java.util.HashSet;
import java.util.Set;

public class Skills implements Skilled {
	private Set<Object> skillSet = new HashSet<Object>();

	public boolean hasSkill(Enum skill) {
		return skillSet.contains(skill);
	}

	public void addSkill(Enum skill) {
		skillSet.add(skill);
	}

	public void removeSkill(Enum skill) {
		skillSet.remove(skill);
	}
}
