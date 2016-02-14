package com.jarosoftware.estudio.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jarosoftware.estudio.beans.interfaces.AsignaturaDAOLocal;
import com.jarosoftware.estudio.model.Asignatura;
import com.jarosoftware.estudio.model.AsignaturaHorario;

@ViewScoped
@ManagedBean
public class AsignaturaMB {
	
	@EJB
	public AsignaturaDAOLocal asignaturaDAOLocal;
	
	public Asignatura asignaturaForm = new Asignatura();
	public AsignaturaHorario asignaturaHorarioForm = new AsignaturaHorario();
	public ArrayList<AsignaturaHorario> listaAsignaturaHorarioForm = new ArrayList<AsignaturaHorario>();
	private List<String> week;
	private String[] weekSelecteds;
	
	@PostConstruct
    public void init() {
        week = new ArrayList<String>();
        week.add("general.day.monday");
        week.add("general.day.tuesday");
        week.add("general.day.wednesday");
        week.add("general.day.thursday");
        week.add("general.day.friday");
        week.add("general.day.saturday");
        week.add("general.day.sunday");
        
        weekSelecteds = new String[week.size()];
        weekSelecteds[0] = "general.day.monday";
        weekSelecteds[1] = "general.day.friday";
        weekSelecteds[2] = "general.day.sunday";
        
    }

	public void create() {
		asignaturaDAOLocal.create(asignaturaForm);
	}
	
	public void update() {
		asignaturaDAOLocal.update(asignaturaForm);
	}
	
	public void delete(long codigo) {
		asignaturaDAOLocal.remove(codigo);
	}
	
	public void getAsignatura(long codigo) {
		asignaturaForm = asignaturaDAOLocal.getAsignatura(codigo);
	}
	
	public List<Asignatura> getAllAsignaturas() {
		return asignaturaDAOLocal.getAllAsignaturas();
	}
	
	public void addHour() {
		
		for (int i = 0; i < weekSelecteds.length; i++) {
			asignaturaHorarioForm.setDiaSemana(weekSelecteds[i]);
			listaAsignaturaHorarioForm.add((AsignaturaHorario) asignaturaHorarioForm.clone());
		}
	}
	
	// ----------------> Atributos propios

	public ArrayList<AsignaturaHorario> getListaAsignaturaHorarioForm() {
		return listaAsignaturaHorarioForm;
	}

	public Asignatura getAsignaturaForm() {
		return asignaturaForm;
	}

	public void setAsignaturaForm(Asignatura asignaturaForm) {
		this.asignaturaForm = asignaturaForm;
	}

	public AsignaturaHorario getAsignaturaHorarioForm() {
		return asignaturaHorarioForm;
	}

	public void setAsignaturaHorarioForm(AsignaturaHorario asignaturaHorarioForm) {
		this.asignaturaHorarioForm = asignaturaHorarioForm;
	}

	public List<String> getWeek() {
		return week;
	}

	public void setWeek(List<String> week) {
		this.week = week;
	}

	public String[] getWeekSelecteds() {
		return weekSelecteds;
	}

	public void setWeekSelecteds(String[] weekSelecteds) {
		this.weekSelecteds = weekSelecteds;
	}
}
