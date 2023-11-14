package com.mitocode.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Archivo;
import com.mitocode.repo.IArchivoRepo;
import com.mitocode.service.IArchivoService;

@Service
public class ArchivoServiceImpl implements IArchivoService {

	// @Value("{media.location}")
	// private String mediaLocation;
	// private Path rootLocation;

	@Autowired
	private IArchivoRepo repo;

	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = repo.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}

	@Override
	public byte[] leerArchivo(Integer idArchivo) {		
		// Optional<Archivo> op = repo.findById(idArchivo);		
		Optional<Archivo> op = repo.findLast();
		return op.isPresent() ? op.get().getValue() : new byte[0];
	}

	// @Override
	// public String store(MultipartFile file) {
	// 	try {
	// 		if(file.isEmpty()){
	// 			throw new RuntimeException("File to storage is empty.");
	// 		}
	// 		String filename = file.getOriginalFilename();
	// 		Path destintionFile = rootLocation.resolve(Paths.get(filename)).
	// 			normalize().toAbsolutePath();
	// 		try (InputStream inputStream = file.getInputStream()){
	// 			Files.copy(inputStream, destintionFile, StandardCopyOption.REPLACE_EXISTING);
	// 		}
	// 		return filename;
	// 	} catch(IOException e){
	// 		throw new RuntimeException("Fail to Store File. " + e); }
	// }

	// @Override
	// public Resource loadResource(String filename) {
	// 	try {
	// 		Path file = rootLocation.resolve(filename);
	// 		Resource resource = new UrlResource((file.toUri()));

	// 		if(resource.exists() || resource.isReadable()){
	// 			return resource;
	// 		} else {
	// 			throw new RuntimeException("Could not read file: " + filename);
	// 		}
	// 	} catch (MalformedURLException e) {
	// 		throw new RuntimeException("Could not read file: " + filename);
	// 	}
	
	// }

	// @Override
	// @PostConstruct
	// public void init() {
	// 	rootLocation = Paths.get(mediaLocation);
	// 	try {
	// 		Files.createDirectories(rootLocation);
	// 	} catch (IOException e) {
	// 		throw new RuntimeException("No se pudo crear el directorio. " + rootLocation);
	// 	}
	// }

	

}
