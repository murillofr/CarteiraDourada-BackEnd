package com.carteiraDourada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carteiraDourada.models.Infracao;
import com.carteiraDourada.models.InfracaoUsuario;
import com.carteiraDourada.models.Usuario;
import com.carteiraDourada.models.Veiculo;
import com.carteiraDourada.services.InfracaoService;
import com.carteiraDourada.services.InfracaoUsuarioService;
import com.carteiraDourada.services.UsuarioService;
import com.carteiraDourada.services.VeiculoService;

import java.util.Date;

@SpringBootApplication
public class CarteiraDouradaApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService userService;

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private InfracaoService infracaoService;

	@Autowired
	private InfracaoUsuarioService infracaoUsuarioService;

	public static void main(String[] args) {
		SpringApplication.run(CarteiraDouradaApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Usuario usuario = new Usuario("Walter", "walter@iftm.edu.br", "12345678", "A, B");
		userService.insert(usuario);
		usuario.setId(1);

		Veiculo veiculo = new Veiculo("Fiesta","ABC1234","12345678", usuario);
		veiculoService.insert(veiculo);
		veiculo.setId(1);

		Infracao infracao = new Infracao("Excesso de Velocidade", 7);
		infracaoService.insert(infracao);
		infracao.setId(1);
	}
}

/* SEMPRE REALIZAR ESSE INSERT PARA MAIOR CONTROLE DE INFRACOES
{
	"usuario":{
		"id": 1,
        "nome": "Elton",
        "email": "elton@iftm.edu.br",
        "cnh": "12345678",
        "categoria": "A, B"
	},
	"infracao":{
		"id":1,
		"nome":"teste",
		"pontuacao": 3
	},
	"veiculo":{
		"id": 1,
		"modelo":"fiestaasd",
		"placa":"ABC1234",
		"renavam":"12345678"
	}
}
* */
