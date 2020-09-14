/**
 * 
 */
package co.ke.bsl.pojo;

import android.content.Context;

/**
 * @author allan
 * 
 *         Models User
 * 
 */

public class User {

	private int userID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String status;
	private int warehouseID;
	private int clientID;
	private int roleID;
	private int orgID;

	public  User (){

	}

	public int getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(int warehouseID) {
		this.warehouseID = warehouseID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getOrgID() {
		return orgID;
	}

	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	private Context ctx;

	public User(Context context) {
		this.ctx = context;
	}

	public User(String uname) {
		this.username = uname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	// User login
	public boolean login(String uname, String pass, String url) {
/*
		ConnectionManager manager = new ConnectionManager(ctx);

		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("username", uname));
		pairs.add(new BasicNameValuePair("pass", pass));

		String responseString = manager.httpRequest(url, pairs);

		if (responseString != null) {

			try {
				org.json.JSONObject obj = new org.json.JSONObject(
						responseString);
				String response = obj.getString("responseCode");
				if (response.equals("0")) {
					
					org.json.JSONObject userDetails = new org.json.JSONObject(obj.getString("content"));
					
					setUserID(userDetails.getInt("userID"));
					
					return true;
				} else {
					return false;
				}
			} catch (JSONException e) {
				Log.e("ERROR", "There was a problem parsing JSON response.");
				e.printStackTrace();
		ConnectionManager manager = new ConnectionManager(ctx);

		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("username", uname));
		pairs.add(new BasicNameValuePair("pass", pass));

		String responseString = manager.httpRequest(url, pairs);

		if (responseString != null) {

			try {
				org.json.JSONObject obj = new org.json.JSONObject(
						responseString);
				String response = obj.getString("responseCode");
				if (response.equals("0")) {
					
					org.json.JSONObject userDetails = new org.json.JSONObject(obj.getString("content"));
					
					setUserID(userDetails.getInt("userID"));
					
					return true;
				} else {
		ConnectionManager manager = new ConnectionManager(ctx);

		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("username", uname));
		pairs.add(new BasicNameValuePair("pass", pass));

		String responseString = manager.httpRequest(url, pairs);

		if (responseString != null) {

			try {
				org.json.JSONObject obj = new org.json.JSONObject(
						responseString);
				String response = obj.getString("responseCode");
				if (response.equals("0")) {
					
					org.json.JSONObject userDetails = new org.json.JSONObject(obj.getString("content"));
					
					setUserID(userDetails.getInt("userID"));
					
					return true;
				} else {
		ConnectionManager manager = new ConnectionManager(ctx);

		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("username", uname));
		pairs.add(new BasicNameValuePair("pass", pass));

		String responseString = manager.httpRequest(url, pairs);

		if (responseString != null) {

			try {
				org.json.JSONObject obj = new org.json.JSONObject(
						responseString);
				String response = obj.getString("responseCode");
				if (response.equals("0")) {
					
					org.json.JSONObject userDetails = new org.json.JSONObject(obj.getString("content"));
					
					setUserID(userDetails.getInt("userID"));
					
					return true;
				} else {
					return false;
				}
			} catch (JSONException e) {
				Log.e("ERROR", "There was a problem parsing JSON response.");
				e.printStackTrace();
			}
		}
					return false;
				}
			} catch (JSONException e) {
				Log.e("ERROR", "There was a problem parsing JSON response.");
				e.printStackTrace();
			}
		}
					return false;
				}
			} catch (JSONException e) {
				Log.e("ERROR", "There was a problem parsing JSON response.");
				e.printStackTrace();
			}
		}
			}
		}*/
		return false;
	}

	// User registration
	public boolean register(String uname, String fname, String lname,
			String pass, String email, String url) {

		/*ConnectionManager manager = new ConnectionManager(ctx);

		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("userType", "1"));
		pairs.add(new BasicNameValuePair("username", uname));
		pairs.add(new BasicNameValuePair("pass", pass));
		pairs.add(new BasicNameValuePair("fname", fname));
		pairs.add(new BasicNameValuePair("lname", lname));
		pairs.add(new BasicNameValuePair("email", email));*/

/*		String responseString = manager.httpRequest(url, pairs);

		if (responseString != null) {

			try {
				org.json.JSONObject obj = new org.json.JSONObject(
						responseString);
				String responseCode = obj.getString("responseCode");
				if (responseCode.equals("0")) {
					
					return true;
					
				} else if (responseCode.equals("1")) {
					// Username already exists
					this.setStatus(obj.getString("message"));
					Log.d("ERROR", "Username already exists?");
					return false;
				} else {
					return false;
				}
			} catch (JSONException e) {
				Log.e("ERROR", "There was a problem parsing JSON response.");
				e.printStackTrace();
			}
		}*/
		return false;
	}

	public boolean remindPassword(String email, String url) {
		
		/*ConnectionManager manager = new ConnectionManager(ctx);

		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("email", email));
		
		String responseString = manager.httpRequest(url, pairs);

		if (responseString != null) {

			try {org.json.JSONObject obj = new org.json.JSONObject(
						responseString);
					String responseCode = obj.getString("responseCode");
					if (responseCode.equals("0")) {
						
						return true;
					}
					else if(responseCode.equals("1"))
					{
						this.setStatus(obj.getString("There was a problem sending the email. Ensure you put in the email" +
								"you provided."));
						Log.d("ERROR", "There was a problem sending the email");
						return false;
					}
					else {
						return false;
					}
				}
				catch(JSONException jse){
					Log.e("ERROR", "There was a problem parsing JSON response.");
					jse.printStackTrace();
				}
		}*/
		return false;
	}
}
