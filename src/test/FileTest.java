package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {

	final String ORIGEM = "C:\\Users\\diego.silveira\\Documents\\origem\\";
	final String DESTINO = "C:\\Users\\diego.silveira\\Documents\\destino\\";

	String nomeArquivo = "1234567890.txt";
	String nomeAlterado = "1234567890VALIDADO.txt";

	File file = new File(ORIGEM + nomeArquivo);

	public void validacaoArquivo() {

		try {
			file.createNewFile();
			if (!((file.exists()) || (file.canRead() || file.isFile()) || file.canWrite())) {
				System.out.println("Erro!");

			}
			moveArquivo();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void moveArquivo() {

		Path temp;
		try {
			temp = Files.move(Paths.get(ORIGEM + nomeArquivo), Paths.get(DESTINO + nomeAlterado));

			if (temp != null) {
				System.out.println("Arquivo renomeado e movido com sucesso!");
			} else {
				System.out.println("Falha ao mover arquivo!");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
