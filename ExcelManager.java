import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ExcelManager{
	public ExcelManager(){
		
	}
	
	
	public ArrayList<Trabajador> cargartrabajadores(){
	ArrayList<Trabajador> resultado = new ArrayList<Trabajador>();
	FileInputStream file = new FileInputStream("SistemasInformacionII.xlsx");
	XSSFWorkbook hojaexcel = new XSSFWorkbook(file);
	try {
		 file = new FileInputStream(new File("Practica2.xlsx"));
		System.out.println("Archivo cargado");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		 hojaexcel = new XSSFWorkbook(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	XSSFSheet sheet = hojaexcel.getSheetAt(0);
	Iterator<Row> rowIterator = sheet.iterator();
	Row row;
	int contador = 0;
	row = rowIterator.next(); //Saltamos la primera linea
	while (rowIterator.hasNext()){
		Trabajador aux = new Trabajador();
		row = rowIterator.next();
		Cell celda;
		//Añadiendo id
		aux.id = contador;
		contador = contador + 1;
		//Cargando nombre
		celda = row.getCell(0);
		if (celda != null){
			aux.nombre=celda.getStringCellValue();
		}
		//Cargando apellido1
		 celda = row.getCell(1);
		if (celda != null){
			aux.apellido1=celda.getStringCellValue();
		}
		//Cargando apellido2
		 celda = row.getCell(2);
			if (celda != null){
				aux.apellido2=celda.getStringCellValue();
			}
		//Cargando dni
			celda = row.getCell(3);
			if (celda != null){
				aux.setdni(celda.getStringCellValue().toString());
			}
			
		//Añadiendo nuevo registro a la lista
			resultado.add(aux);
			
	}
	try {
		hojaexcel.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resultado;
	}
	
	
	public void guardartrabajadores(ArrayList<Trabajador> trabajadores){
		FileInputStream file = null;
		FileOutputStream fileout  = null;
		XSSFWorkbook hojaexcel = null;
		try {
			 file = new FileInputStream(new File("Practica2.xlsx"));
			System.out.println("Archivo cargado");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 hojaexcel = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = hojaexcel.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		Row row;
		row = rowIterator.next(); //Saltamos la primera linea
		for (int i = 0; i < trabajadores.size();i++){
			row = rowIterator.next();
			//Guardando datos Nombre
			String nombre = trabajadores.get(i).nombre;
			if (nombre != null){
			row.getCell(0).setCellValue(nombre);
			}
			//Guardando datos Apellidos
			String ap1 = trabajadores.get(i).apellido1;
			String ap2 = trabajadores.get(i).apellido2;
			if (ap1 != null){
			row.getCell(1).setCellValue(ap1);
			}
			if (ap2 != null){
			row.getCell(2).setCellValue(ap2);
			}
			//Guardando datos dni
			String dn = trabajadores.get(i).getdni();
			if (dn != null){
			row.getCell(3).setCellValue(dn);
			}
		}
		try {
			file.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fileout = new FileOutputStream(new File("Practica2.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hojaexcel.write(fileout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}