package CrudOps.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Courseentity {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@JsonIgnore
	private int id;
	private String name;
	@JsonFormat(pattern = "dd/mm/yy")
	private Date dos;
	private double amount;
	private boolean isCerticateavailable;
	
	
	public Courseentity( String name,  int amount) {
		
		super();
		this.name=name;
		this.amount=amount;
		//this.isCerticateavailable=isCerticateavailable;
	}
	

}
