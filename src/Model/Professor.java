package Model;

public class Professor {
	private int id;
	private String nome;
	private String rgf;
	private String rg;

	public Professor() {
	}

	public Professor(String nome, String rgf, String rg) {
		super();
		this.nome = nome;
		this.rgf = rgf;
		this.rg = rg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRgf() {
		return rgf;
	}

	public void setRgf(String rgf) {
		this.rgf = rgf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", rgf=" + rgf + ", rg=" + rg + "]";
	}
}
