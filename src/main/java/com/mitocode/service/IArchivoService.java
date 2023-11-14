package com.mitocode.service;

import com.mitocode.model.Archivo;

public interface IArchivoService {

	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);

	// String store(MultipartFile file);
	// Resource loadResource(String filename);
	// void init();
}
