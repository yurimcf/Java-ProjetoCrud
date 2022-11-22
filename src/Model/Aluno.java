package Model;

public class Aluno {
	private int id;
	private String nome;
	private String ra;
	private String rg;

	public Aluno() {
		
	}
	

	public Aluno(int id) {
		super();
		this.id = id;
	}


	public Aluno(String nome, String ra, String rg) {
		super();
		this.nome = nome;
		this.ra = ra;
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

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", ra=" + ra + ", rg=" + rg + "]";
	}	
	
}
