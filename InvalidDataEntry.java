package com.hospital.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class InvalidDataEntry extends RuntimeException
{
	String msg;

}
