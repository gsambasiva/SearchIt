package com.search.searchit.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

	@Column(name="created_at")
	@CreationTimestamp
	private LocalDateTime createDateTime;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
	
}