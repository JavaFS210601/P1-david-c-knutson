package com.revature.models;

public class Expense {
	
	private int reimb_id;
	private double reimb_amount;
	private String reimb_submitted;
	private String reimb_resolved;
	private String reimb_description;
	private int reimb_author;
	private int reimb_resolver;
	private int reimb_status_id;
	private int reimb_type_id;

	 
	//boiler plater code below---------------------------------------------------------------------
	
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expense(int reimb_id, double reimb_amount, String reimb_submitted, String reimb_resolved,
			String reimb_description, int reimb_author, int reimb_resolver, int reimb_status, int reimb_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status;
		this.reimb_type_id = reimb_type;
	}
	
	public Expense( double reimb_amount, String reimb_submitted, String reimb_resolved,
			String reimb_description, int reimb_author, int reimb_resolver, int reimb_status, int reimb_type) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status;
		this.reimb_type_id = reimb_type;
	}
	

	@Override
	public String toString() {
		return "Expense [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_author=" + reimb_author + ", reimb_resolver=" + reimb_resolver + ", reimb_status="
				+ reimb_status_id + ", reimb_type=" + reimb_type_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimb_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimb_author;
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + reimb_id;
		result = prime * result + ((reimb_resolved == null) ? 0 : reimb_resolved.hashCode());
		result = prime * result + reimb_resolver;
		result = prime * result + reimb_status_id;
		result = prime * result + ((reimb_submitted == null) ? 0 : reimb_submitted.hashCode());
		result = prime * result + reimb_type_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		if (Double.doubleToLongBits(reimb_amount) != Double.doubleToLongBits(other.reimb_amount))
			return false;
		if (reimb_author != other.reimb_author)
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		if (reimb_resolved == null) {
			if (other.reimb_resolved != null)
				return false;
		} else if (!reimb_resolved.equals(other.reimb_resolved))
			return false;
		if (reimb_resolver != other.reimb_resolver)
			return false;
		if (reimb_status_id != other.reimb_status_id)
			return false;
		if (reimb_submitted == null) {
			if (other.reimb_submitted != null)
				return false;
		} else if (!reimb_submitted.equals(other.reimb_submitted))
			return false;
		if (reimb_type_id != other.reimb_type_id)
			return false;
		return true;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(String reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public String getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(String reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	public int getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status) {
		this.reimb_status_id = reimb_status;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type) {
		this.reimb_type_id = reimb_type;
	}
	
	
	

}
