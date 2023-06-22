package com.spring.beans;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThanhToanForm {
	@NotBlank(message = "{NotBlank.thanhtoan.tennguoinhan}")
	@Length(max =100 , message = "{Length.thanhtoan.tennguoinhan}")
	private String tenNguoiNhan;
	@NotBlank(message = "{NotBlank.thanhtoan.sdtnguoinhan}")
	@Length(min =  10 , max =  10 , message = "{Length.thanhtoan.sdtnguoinhan}")
	private String sdtNguoiNhan;
	@NotBlank(message = "{NotBlank.thanhtoan.diachinguoinhan}")
	@Length(max =  100 , message = "{Length.thanhtoan.diachinguoinhan}")
	private String diaChiNguoiNhan;
}
