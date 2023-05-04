package controller;

import java.io.IOException;

public interface IOrganizadorTabela {

	void leArquivo(String path, String arquivo) throws IOException;

	void leDir(String path) throws IOException;

}
