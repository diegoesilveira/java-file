package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import exception.ErrorFileException;

public class ProcessaArquivos {

	final String ORIGEM = "C:\\Users\\diego.silveira\\Documents\\EDI\\origem\\";
	final String DESTINO = "C:\\Users\\diego.silveira\\Documents\\EDI\\destino\\";
	final String ERRO = "C:\\Users\\diego.silveira\\Documents\\EDI\\erro\\";

	File files = new File(ORIGEM);
	Path temp;

	public void validacaoArquivo() {

		for (File file : files.listFiles()) {

			if (!file.canWrite() || !file.canRead() || !file.isFile()) {
				try {
					System.out.println("Entrou na condição erro");
					temp = Files.move(Paths.get(ORIGEM + file.getName()), Paths.get(ERRO + "erro" + file.getName()));
				} catch (IOException e) {
					e.getMessage();
				}

			}
			moveArquivo(file.getName());

		}

	}

	private void moveArquivo(String nomeArquivo) {

		try {
			temp = Files.move(Paths.get(ORIGEM + nomeArquivo), Paths.get(DESTINO + "ok" + nomeArquivo));

			if (temp != null) {
				System.out.println("Arquivo renomeado e movido com sucesso!");
			} else {
				new ErrorFileException("Falha ao mover arquivo");
			}
		} catch (IOException e) {
			e.getMessage();

		}
	}

}
