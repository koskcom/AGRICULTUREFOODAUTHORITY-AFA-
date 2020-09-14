package co.ke.bsl.pojo;

import java.io.Serializable;

/**
 * @author kirwa
 *
 */
public class CBPartner implements Serializable{
	private String c_bpartner_id;
	private String name;

	public String getC_bpartner_id() {
		return c_bpartner_id;
	}

	public void setC_bpartner_id(String c_bpartner_id) {
		this.c_bpartner_id = c_bpartner_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
