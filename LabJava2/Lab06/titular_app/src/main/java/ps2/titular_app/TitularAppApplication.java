package ps2.titular_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static ps2.titular_app.ES.*;

import java.util.Optional;

@SpringBootApplication
public class TitularAppApplication implements CommandLineRunner {

	@Autowired
	private TitularRepo titularrepo;

	public static void main(String[] args) {
		SpringApplication.run(TitularAppApplication.class, args);
	}

	public void criar(String nome, String cpf) {
		Titular t;
		t = new Titular();
		t.setNome(nome);
		t.setCpf(cpf);
		titularrepo.save(t);
		System.out.println("Titular criado com o id " + t.getId());
	}

	public void lerTudo() {
		Iterable<Titular> titulares = titularrepo.findAll();
		for (Titular t : titulares) {
			System.out.println(t);
		}
	}

	public Optional<Titular> buscarID(long id) {
		return titularrepo.findById(id);
	}

	public void alterarDados(Titular titular) {
		titular.setNome(input("Novo nome: "));
		titular.setCpf(input("Novo CPF: "));
		titularrepo.save(titular);
		System.out.println("Dados alterados!");
	}

	public void deletar(Titular titular) {
		titularrepo.delete(titular);
		System.out.println("Titular deletado!");
	}



	@Override
	public void run(String... args) throws Exception {
		System.out.println("# GERENCIADOR DE TITULARES!");
		boolean sair = false;
		String menu = "\n(1) Listar todos os titulares";
		menu += "\n(2) Buscar um titular específico pelo número";
		menu += "\n(3) Criar um novo titular";
		menu += "\n(4) Alterar os dados do titular";
		menu += "\n(5) Apagar um titular";
		menu += "\n(0) Sair \n";
		menu += "Escolha uma opção: ";

		while (!sair) {
			String op = input(menu);
			switch (op) {
				case "1":
					lerTudo();
					break;
				case "2":
					Optional<Titular> titularBusca = buscarID(Long.parseLong(input("ID para pesquisa: ")));
					if (titularBusca.isPresent()) System.out.println(titularBusca.get().toString());
					else System.out.println("Não encontrado!");
					break;
				case "3":
					String nome = input("Nome: ");
					String cpf = input("CPF: ");
					criar(nome, cpf);
					break;
				case "4":
					Optional<Titular> titularAltera = buscarID(Long.parseLong(input("ID para alteração: ")));
					if(!titularAltera.isPresent()) {
						System.out.println("Não encontrado!");
					} else {
						System.out.println("Titular encontrado:");
						System.out.println(titularAltera.get().toString());
						alterarDados(titularAltera.get());
					}
					break;
				case "5":
					Optional<Titular> titularDeleta = buscarID(Long.parseLong(input("ID para deleção: ")));
					if(!titularDeleta.isPresent()) {
						System.out.println("Não encontrado!");
					} else {
						System.out.println("Titular encontrado");
						System.out.println(titularDeleta.get().toString());
						deletar(titularDeleta.get());
					}
					break;
				case "0":
					sair = true;
					break;
				default:
					print("Opção inválida!");
			}
		}
	}

}