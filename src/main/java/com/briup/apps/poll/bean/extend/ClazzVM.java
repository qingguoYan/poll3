package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.User;

public class ClazzVM {

   private Long id;
   private String name;
   private Long gradeId;
   private Long chargeId;
   private String description;
   private Grade grade;
   private User charge;
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getChargeId() {
        return chargeId;
    }

    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public User getCharge() {
		return charge;
	}

	public void setCharge(User charge) {
		this.charge = charge;
	}

	
}
