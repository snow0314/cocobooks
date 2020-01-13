package bean;

public class Declaration {
	int story_num;
	String name; //신고한 아이디
	String id; //신고받은 아이디
	String cartegory;
	String diteil;
	
	public int getStory_num() {
		return story_num;
	}
	public void setStory_num(int story_num) {
		this.story_num = story_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCartegory() {
		return cartegory;
	}
	public void setCartegory(String cartegory) {
		this.cartegory = cartegory;
	}
	public String getDiteil() {
		return diteil;
	}
	public void setDiteil(String diteil) {
		this.diteil = diteil;
	}
	
}
