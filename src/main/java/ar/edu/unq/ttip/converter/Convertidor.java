package ar.edu.unq.ttip.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unq.ttip.entity.Proyecto;
import ar.edu.unq.ttip.model.MProyecto;

@Component("convertidor")
public class Convertidor {
	public List<MProyecto> convertirLista(List<Proyecto> proyectos){
		List<MProyecto> mproyectos = new ArrayList<>();
		proyectos.forEach(proyecto -> mproyectos.add(new MProyecto(proyecto)));
		return mproyectos;
	}
}
