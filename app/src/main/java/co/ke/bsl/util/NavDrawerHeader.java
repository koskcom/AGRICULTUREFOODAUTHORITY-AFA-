/**
 * 
 */
package co.ke.bsl.sisdo.util;

/**
 *created by ryanmunene 24/01/16*
 *
 */
public class NavDrawerHeader {
	
	private String title;
	private int icon;
	
	public NavDrawerHeader(String menuTitle, int itemIcon){
		this.title = menuTitle;
		this.icon = itemIcon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

}
