package autenticador;

public class Usuario
{
	
	private String login;
	private String password;
	private String tipoUsuario;
	
	
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
	

	@Override
	public String toString()
	{
		return "Usuario [login=" + login + ", password=" + password + ", tipoUsuario=" + tipoUsuario + "]";
	}

}
