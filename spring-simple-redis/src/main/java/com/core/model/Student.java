package com.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;

@RedisHash("Student")
@Data
@AllArgsConstructor
public class Student {
	public enum Gender {
		MALE, FEMALE
	}

	@Id
	private String id;
	@Indexed
	private String externalId;
	private String name;
	private Gender gender;
	private int grade;

}
