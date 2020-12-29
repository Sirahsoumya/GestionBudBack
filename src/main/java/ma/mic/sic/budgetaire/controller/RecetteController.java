package ma.mic.sic.budgetaire.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.mic.sic.budgetaire.entity.Programme;
import ma.mic.sic.budgetaire.entity.Recette;
import ma.mic.sic.budgetaire.repository.RecetteRepository;


@RestController
@RequestMapping(value = "recettes")
@CrossOrigin(origins = "http://localhost:4200")
public class RecetteController {
	@Autowired
	private  RecetteRepository recetteRepository;
	 private static String[] columns = { "Code économique", "Montant","Date", "Division",
	    "Type" };
	@PostMapping("/save")
	public void Save(@RequestBody Recette recette) {
		recetteRepository.save(recette);
	}

	@DeleteMapping("/delete/{idRecette}")
	public void Delete(@PathVariable(required = true) String idRecette) {
		Recette recette =recetteRepository.findById(Integer.parseInt(idRecette));
		recetteRepository.delete(recette);
	}

	@GetMapping("/all")
	public List<Recette> findAll() {
		return recetteRepository.findAll();
	}
	
	 // export to Excel
    @GetMapping("/fichierExcelRectte")
    public void generateExcel(HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        
        // le style des entetes
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.GREEN.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        
        
        Sheet sheet = workbook.createSheet("Recettes");
        List<Recette> recettes = recetteRepository.findAll();
        // Create a Row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
          Cell cell = headerRow.createCell(i);
          cell.setCellValue(columns[i]);
          cell.setCellStyle(headerCellStyle);
        }
        
        int rowNum = 1;
        for(Recette recette : recettes) {
             Row row = sheet.createRow(rowNum++);
              row.createCell(0).setCellValue(recette.getCodeEconomique());
              row.createCell(1).setCellValue(recette.getMontant());
              row.createCell(2).setCellValue(recette.getDate());
              row.createCell(3).setCellValue(recette.getDivision().getLibelle());    
              row.createCell(4).setCellValue(recette.getType().getLigne());    
        }
        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
          sheet.autoSizeColumn(i);
        }
        FileOutputStream fileOut = new FileOutputStream("Recette.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        
         InputStream inputStream = new FileInputStream(new File("Recette.xlsx")); //load the file
         IOUtils.copy(inputStream, response.getOutputStream());
         response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition",
                    "attachment; filename=Recette.xlsx");
          response.flushBuffer();



}
    
    @GetMapping("/findById/{idRecette}")
	 public Recette findRecetteById(@PathVariable(required = true) String idRecette)  {
		return recetteRepository.findById(Integer.parseInt(idRecette));
				
			}
			
	@PatchMapping("/rec/{idRecette}")
	public void update(@RequestBody  Recette Recette,@PathVariable(required = true) String idRecette ) {
		recetteRepository.save(Recette);
			
			
			}

}
