
public class user implements validator{

	private String nickName;
	private String password;
	
	public user(String nickName, String password) {
		this.setNickName(nickName);
		this.setPassword(password);
	}
	
	public String getNickName() {
		return this.nickName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean checking(String nickname) throws InvalidNicknameException{
		if (nickname.length() > 5) {
	        return true;
	    } else {
	        throw new InvalidNicknameException("Not a valid nickname");
	    }
	}
}
