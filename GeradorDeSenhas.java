package geradorDeSenhas;

import java.util.Random;

public class GeradorDeSenhas {
	public static void main(String[] args) {

		int comprimento = 10;
		String senha = gerarSenha(comprimento);
		System.out.println("Senha gerada: " + senha);

	}

	private static String gerarSenha(int comprimento) {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
		Random random = new Random();
		StringBuilder senha = new StringBuilder();
		boolean numeroIncluido = false;
		boolean caractereEspecialIncluido = false;
		boolean MaisculoIncluido = false;

		for (int i = 0; i < comprimento; i++) {
			int indice = random.nextInt(caracteres.length());
			char caractere = caracteres.charAt(indice);

			if (Character.isDigit(caractere)) {
				numeroIncluido = true;
			}
			if (Character.isUpperCase(caractere)) {
				MaisculoIncluido = true;

			}
			if (!Character.isDigit(caractere) && !Character.isUpperCase(caractere)) {
				caractereEspecialIncluido = true;
			}

			senha.append(caractere);
		}

		if (!numeroIncluido || !MaisculoIncluido || !caractereEspecialIncluido) {

			char novoNumero;
			do {
				int indice = random.nextInt(caracteres.length());
				novoNumero = caracteres.charAt(indice);

			} while (!Character.isDigit(novoNumero));

			int indiceAleatorio = random.nextInt(comprimento);
			senha.setCharAt(indiceAleatorio, novoNumero);

		}
		return senha.toString();
	}

}