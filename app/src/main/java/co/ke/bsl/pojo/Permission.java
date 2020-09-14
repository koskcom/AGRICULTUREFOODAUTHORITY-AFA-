package co.ke.bsl.pojo;
// Generated Dec 15, 2015 12:42:43 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Permissions generated by hbm2java
 */

public class Permission  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Date dateCreated;

    public Permission() {
    }

    public Permission(String name, Date dateCreated) {
       this.name = name;
       this.dateCreated = dateCreated;
    }

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
   
     


}


