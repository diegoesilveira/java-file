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
	final String ERRO = "C:\\Users\\diego.silveira\\Documents\\EDI\\origem\\";

	File files = new File(ORIGEM);

	public void validacaoArquivo() {

		if (!((files.exists()) || (files.canRead() || files.isFile()) || files.canWrite())) {
			
			new ErrorFileException("Erro ao tentar manipular arquivo");
		}
		for (File file : files.listFiles()) {
			moveArquivo(file.getName());
		}
	}
	
	private void moveArquivo(String nomeArquivo) {

		Path temp;
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
