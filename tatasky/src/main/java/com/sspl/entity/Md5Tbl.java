package com.sspl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Md5Tbl {

	@Id
    @Column(name="bankid")
    @GeneratedValue
    private Integer id;

    @Column(name="bankname")
    private String md5Val;

	public String getMd5Val() {
		return md5Val;
	}

	public void setMd5Val(String md5Val) {
		this.md5Val = md5Val;
	}
}
