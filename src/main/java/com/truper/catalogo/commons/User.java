package com.truper.catalogo.commons;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String username;
	private String token;

}
