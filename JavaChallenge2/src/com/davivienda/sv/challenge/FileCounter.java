package com.davivienda.sv.challenge;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileCounter {
private String fileContent;
	
	public FileCounter(String content) {
		this.fileContent = content;
	}
	
	/**
	 * @return Retorna la cantidad de capitulos en el libro 
	 */
	public int getChapterCount() {
		//TODO: Implementar
		Pattern pattern = Pattern.compile("CHAPTER", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(fileContent);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}
	
	/**
	 * @return Retorna la cantidad de veces que es mencionado le nombre de Dracula en el libro
	 */
	public int getDraculaMentionCount() {
		//TODO: Implementar
		Pattern pattern = Pattern.compile("\\bDracula\\b", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(fileContent);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
            return count;
	}
	
	/**
	 * @return Retorna el capitulo con mas lineas de contenido en el libro
	 */
	public int getBiggestChapter() {
		//TODO: Implementar
		Pattern pattern = Pattern.compile("(?i)CHAPTER (\\w+)");
		Matcher matcher = pattern.matcher(fileContent);
		
		int maxChapterLines = 0;
		int currentChapterLines = 0;
		
		while (matcher.find()) {
			String ChapterTitle = matcher.group(1);
			int chapterStartIndex = matcher.start();
			int nextChapterIndex = matcher.find(matcher.start()+1) ? matcher.start() : fileContent.length();
			
			String chapterContent = fileContent.substring(chapterStartIndex, nextChapterIndex);
			int chapterLineCount = chapterContent.split("\n").length;
			
			if (chapterLineCount > maxChapterLines) {
				maxChapterLines = chapterLineCount;
			}
		}
		return maxChapterLines;
	}

	/**
	 * @return Retorna la lista de fechas en las cartas, diarios y memorandums mencionados en le libro, en formato String tal cual como aparecen en el libro. Ej. 30 October, 4 November, ... 
	 */
	public List<String> getLetterDates() {
		//TODO: Implementar
		Pattern pattern = Pattern.compile("(?i)(\\d{1,2}\\s(?:January|February|March|April|May|July|August|September|October|November|December))");
		Matcher matcher = pattern.matcher(fileContent);
		
		List<String> dates = new ArrayList<>();
		
		while (matcher.find()) {
			dates.add(matcher.group(1));
		}
		return dates;
	}
	
	/**
	 * @return Retorna la lista de remitentes de las cartas, diarios y memorandums mencoinados en el libro, en formato String tal cual como aparece en el libro. Ej. Jonathan Harker’s Journal, Dr. Van Helsing’s Memorandum, Dr. Seward’s Diary...
	 */
	public List<String> getLetterRecipients() {
		//TODO: Implementar
		Pattern pattern = Pattern.compile("(?i)(\\d{1,2}\\s(?:Jonathan Harker's Journal|Dr\\. Van Helsing's Memorandum|Dr\\. Seward's Diary))");
		Matcher matcher = pattern.matcher(fileContent);
		
		List<String> recipients = new ArrayList<>();
		
		while (matcher.find()) {
			recipients.add(matcher.group(1));
		}
		
		return recipients;
	}
}
