package com.davivienda.sv.challenge;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileManager fm = new FileManager();
		String fileContent = fm.loadFile();
		
		FileCounter fc = new FileCounter(fileContent);
		int chapterCount = fc.getChapterCount();
		int draculaMentionCount = fc.getDraculaMentionCount();
                int biggestchapter = fc.getBiggestChapter();
                List<String> letterDates = fc.getLetterDates();
                List<String> letterRecipients = fc.getLetterRecipients();
		
		System.out.println("Cantidad de capitulos:" + chapterCount);
		System.out.println("Cantidad de meciones a Dracula:" + draculaMentionCount);
                System.out.println("Capitulo con mas lineas de contenido en el libro:" + biggestchapter);
                System.out.println("lista de fechas en las chartas:");
                for (String numero : letterDates) {
                    System.out.println(numero);
                    }
                System.out.println("Lista de remitentes de cartas:");
                for(String numero : letterRecipients) {
                	System.out.println(numero);
                }
	}

}
