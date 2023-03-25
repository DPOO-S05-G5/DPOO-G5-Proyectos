package autenticador;

public class Usuario
{
	
	private String login;
	private String password;
	private String tipoUsuario;
	
	public Usuario()
	{
		
	}
	
	public Usuario(String login, String password, String tipo)
	{
		this.login = login;
		this.password = password;
		this.tipoUsuario = tipo;
	}

	public String getLogin()
	{
		return login;
	}
	
	public String getPassword()
	{
		return password;
	}

	public String getTipoUsuario()
	{
		return tipoUsuario;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setTipoUsuario(String tipoUsuario)
	{
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString()
	{
		return "Usuario [login=" + login + ", password=" + password + ", tipoUsuario=" + tipoUsuario + "]";
	}

}
