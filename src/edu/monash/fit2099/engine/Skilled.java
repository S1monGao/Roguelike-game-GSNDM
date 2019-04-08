package edu.monash.fit2099.engine;


public interface Skilled {
	boolean hasSkill(Enum skill);
	void addSkill(Enum skill);
	void removeSkill(Enum skill);
}