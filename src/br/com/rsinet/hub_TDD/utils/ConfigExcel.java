package br.com.rsinet.hub_TDD.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigExcel {
	/**
	 * Classe de configuração de arquivo e de leitura de dados do excel.
	 */

	public static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

//Determina o método para configurar o arquivo do excel a ser lido
	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

//Abre o arquivo do excel
			FileInputStream ExcelFile = new FileInputStream(Path);

// Acessa a uma determinada planilha com referencia de nome do arquivo e da planilha

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

//Obtem a informaçao da celula da coluna, recebe como parâmetros os valores de linha e coluna

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {
			System.out.println(e);
			return "";

		}

	}

}
